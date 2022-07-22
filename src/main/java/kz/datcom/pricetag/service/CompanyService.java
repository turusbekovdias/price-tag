package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.CompanyDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CompanyService {

    CompanyDTO addCompany (CompanyDTO companyDTO);
    CompanyDTO editCompany (CompanyDTO companyDTO);
    List<CompanyDTO> companyList ();
    CompanyDTO getCompany (ObjectId id) throws Exception;
    Void deleteCompany (ObjectId id);

}
