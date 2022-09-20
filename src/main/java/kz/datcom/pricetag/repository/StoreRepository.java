package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, Long> {
    List<Store> findByCompany(Long id);
}
