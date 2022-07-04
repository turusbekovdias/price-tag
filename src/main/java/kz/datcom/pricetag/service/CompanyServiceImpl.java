package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.CompanyDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class CompanyServiceImpl implements CompanyService{

    @Override
    public Mono<CompanyDTO> addCompany(CompanyDTO companyDTO) {
        return null;
    }

    @Override
    public Mono<CompanyDTO> editCompany(CompanyDTO companyDTO) {
        return null;
    }

    @Override
    public Flux<CompanyDTO> companyList() {
        return null;
    }

    @Override
    public Mono<CompanyDTO> getCompany(ObjectId id) {
        return null;
    }

    @Override
    public Mono<Void> deleteCompany(CompanyDTO companyDTO) {
        return null;
    }
}
