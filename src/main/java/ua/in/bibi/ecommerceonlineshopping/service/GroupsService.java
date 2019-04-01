package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.bibi.ecommerceonlineshopping.dto.request.GroupsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.GroupsResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.Groups;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.GroupsRepository;
import ua.in.bibi.ecommerceonlineshopping.specification.GroupsSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GroupsService {

    @Autowired
    private GroupsRepository groupsRepository;


    //    create
    public GroupsResponse create(GroupsRequest request) {
        return new GroupsResponse(groupRequestToGroup(request, null));
    }


    //    read
    public List<GroupsResponse> findAll() {
        return groupsRepository
                .findAll()
                .stream()
                .map(GroupsResponse::new)
                .collect(Collectors.toList());
    }

    public DataResponse<GroupsResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Groups> groupsPage;
        if (value != null && !value.equals("")) {
            GroupsSpecification specification = new GroupsSpecification(value);
            groupsPage = groupsRepository.findAll(specification, pageRequest);
        } else {
            groupsPage = groupsRepository.findAll(pageRequest);
        }
        return new DataResponse<GroupsResponse>(groupsPage.stream().map(GroupsResponse::new).collect(Collectors.toList()), groupsPage);
    }


    //    update
    public GroupsResponse update(GroupsRequest request, Long id) throws WrongInputException {
        return new GroupsResponse(groupRequestToGroup(request, findOne(id)));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        groupsRepository.delete(findOne(id));
//        groupsRepository.deleteById(id);
    }


    public Groups findOne(Long id) throws WrongInputException {
        return groupsRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Group with id " + id + " not exists"));
    }

    @Transactional
    public GroupsResponse findOneById(Long id) {
        Optional<Groups> groupsOptional = groupsRepository.findById(id);
        if (groupsOptional.isPresent()) {
            return new GroupsResponse(groupsOptional.get());
        } else {
            throw new IllegalArgumentException("Group with id " + id + " not found");
        }
    }


    private Groups groupRequestToGroup(GroupsRequest request, Groups group) {
        if (group == null) {
            group = new Groups();
        }
        group.setName(request.getName());
        return groupsRepository.save(group);
    }

//    @GetMapping("/groups")
//    public List<GroupResponse> findAllGroups() {
//        return groupService.findAll();
//    }
//    @GetMapping("/groups")
//    public Iterable<Groups> getAllB() {
//        return groupsRepository.findAll();
//    }

//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }

}
