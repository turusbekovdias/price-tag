package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Company;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CompanyRepository extends ReactiveCrudRepository<Company, ObjectId> {

}
