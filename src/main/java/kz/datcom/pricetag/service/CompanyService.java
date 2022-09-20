package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.CompanyDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CompanyService {

    CompanyDTO addCompany (CompanyDTO companyDTO) throws Exception;
    List<CompanyDTO> companyList () throws Exception;
    CompanyDTO getCompany (Long id) throws Exception;
    Void deleteCompany (Long id);

}
