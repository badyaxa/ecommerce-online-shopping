package ua.in.bibi.ecommerceonlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ua.in.bibi.ecommerceonlineshopping.dto.request.GroupsRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.GroupsResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.service.GroupsService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/group")
public class GroupsController {

    @Autowired
    private GroupsService groupsService;


    //    create
//    PostMapping("/group")
    @PostMapping
    public GroupsResponse create(@RequestBody @Valid GroupsRequest groupsRequest) {
        return groupsService.create(groupsRequest);
    }

    //    read
//    @GetMapping
    @GetMapping("/all")
    public List<GroupsResponse> findAll() {
//        System.out.println("GET ALL BRANDS");
        return groupsService.findAll();
    }

    @GetMapping
    public DataResponse<GroupsResponse> getGroupsSortPaginationFindValue(
            @RequestParam(required = false) String value,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam String sortFieldName,
            @RequestParam Sort.Direction direction) {
        if (page >= 0) {
            if (size > 0) {
//                System.out.println("GET ALL BRANDS pageble");
                return groupsService.findAll(value, page, size, sortFieldName, direction);
            } else {
                throw new IllegalArgumentException("SIZE id must not be less than ONE!");
            }
        } else {
            throw new IllegalArgumentException("PAGE id must not be less than ZERO!");
        }

    }

    @GetMapping("/{id}")
    public GroupsResponse getGroupById(@PathVariable Long id) {
        if (id > 0) {
//            System.out.println("Get group by id : " + id);
            return groupsService.findOneById(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    update
//    @PutMapping("/group")
    @PutMapping
    public GroupsResponse update(@RequestBody @Valid GroupsRequest groupsRequest, @RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            return groupsService.update(groupsRequest, id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }

    //    delete
//    @DeleteMapping("/group")
    @DeleteMapping
    public void delete(@RequestParam Long id) throws WrongInputException {
        if (id > 0) {
            groupsService.delete(id);
        } else {
            throw new IllegalArgumentException("ID must not be less than ONE!");
        }
    }


//    @PostMapping("/grouppage")
//    public DataResponse<GroupResponse> getPage(@RequestBody PaginationRequest paginationRequest) {
//        return groupService.findAll(paginationRequest);
//    }
}
