package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.CurrentCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentCustomerRepository extends JpaRepository <CurrentCustomer, Integer> {

    CurrentCustomer findByAccount(String account);

}
