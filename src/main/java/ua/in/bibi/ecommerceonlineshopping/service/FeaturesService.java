package ua.in.bibi.ecommerceonlineshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.in.bibi.ecommerceonlineshopping.dto.request.FeaturesRequest;
import ua.in.bibi.ecommerceonlineshopping.dto.response.DataResponse;
import ua.in.bibi.ecommerceonlineshopping.dto.response.FeaturesResponse;
import ua.in.bibi.ecommerceonlineshopping.entity.category.Features;
import ua.in.bibi.ecommerceonlineshopping.exception.WrongInputException;
import ua.in.bibi.ecommerceonlineshopping.repository.FeaturesRepository;
import ua.in.bibi.ecommerceonlineshopping.specification.FeaturesSpecification;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FeaturesService {

    @Autowired
    private FeaturesRepository featuresRepository;


    //    create
    public FeaturesResponse create(FeaturesRequest request) {
        return new FeaturesResponse(featureRequestToBrand(request, null));
    }


    //    read
    public List<FeaturesResponse> findAll() {
        return featuresRepository
                .findAll()
                .stream()
                .map(FeaturesResponse::new)
                .collect(Collectors.toList());
    }

    public DataResponse<FeaturesResponse> findAll(String value, Integer page, Integer size, String fieldName, Sort.Direction direction) {
        Sort sort = Sort.by(direction, fieldName);
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        Page<Features> featuresPage;
        if (value != null && !value.equals("")) {
            FeaturesSpecification specification = new FeaturesSpecification(value);
            featuresPage = featuresRepository.findAll(specification, pageRequest);
        } else {
            featuresPage = featuresRepository.findAll(pageRequest);
        }
        return new DataResponse<FeaturesResponse>(featuresPage.stream().map(FeaturesResponse::new).collect(Collectors.toList()), featuresPage);
    }


    //    update
    public FeaturesResponse update(FeaturesRequest request, Long id) throws WrongInputException {
        return new FeaturesResponse(featureRequestToBrand(request, findOne(id)));
    }


    //    delete
    public void delete(Long id) throws WrongInputException {
        featuresRepository.delete(findOne(id));
//        featuresRepository.deleteById(id);
    }


    public Features findOne(Long id) throws WrongInputException {
        return featuresRepository
                .findById(id)
                .orElseThrow(() -> new WrongInputException("Brand with id " + id + " not exists"));
    }

    @Transactional
    public FeaturesResponse findOneById(Long id) {
        Optional<Features> featuresOptional = featuresRepository.findById(id);
        if (featuresOptional.isPresent()) {
            return new FeaturesResponse(featuresOptional.get());
        } else {
            throw new IllegalArgumentException("Brand with id " + id + " not found");
        }
    }


    private Features featureRequestToBrand(FeaturesRequest request, Features feature) {
        if (feature == null) {
            feature = new Features();
        }
        feature.setName(request.getName());
        return featuresRepository.save(feature);
    }

//    @GetMapping("/features")
//    public List<BrandResponse> findAllFeatures() {
//        return featureService.findAll();
//    }
//    @GetMapping("/features")
//    public Iterable<Features> getAllB() {
//        return featuresRepository.findAll();
//    }

//    public DataResponse<CountryResponse> findAll(PaginationRequest pagination) {
//        Page<Country> all = countryRepository.findAll(pagination.mapToPageRequest());
//        return new DataResponse<>(all.get().map(CountryResponse::new).collect(Collectors.toList()), all.getTotalPages(), all.getTotalElements());
//    }

}
