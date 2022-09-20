package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Company;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
