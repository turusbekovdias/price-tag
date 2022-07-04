package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    public Mono<CompanyDTO> addCompany (CompanyDTO companyDTO) {
        return companyService.addCompany(companyDTO);
    }

    public Mono<CompanyDTO> editCompany (CompanyDTO companyDTO) {
        return companyService.editCompany(companyDTO);
    }

    public Mono<CompanyDTO> getCompany (ObjectId id) {
        return companyService.getCompany(id);
    }

    public Flux<CompanyDTO> companyList() {
        return companyService.companyList();
    }

    public Mono<Void> deleteCompany (CompanyDTO companyDTO) {
        return companyService.deleteCompany(companyDTO);
    }
}
