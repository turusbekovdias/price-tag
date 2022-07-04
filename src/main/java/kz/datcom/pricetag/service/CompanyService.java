package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.CompanyDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CompanyService {

    Mono<CompanyDTO> addCompany (CompanyDTO companyDTO);
    Mono<CompanyDTO> editCompany (CompanyDTO companyDTO);
    Flux<CompanyDTO> companyList ();
    Mono<CompanyDTO> getCompany (ObjectId id);
    Mono<Void> deleteCompany (CompanyDTO companyDTO);

}
