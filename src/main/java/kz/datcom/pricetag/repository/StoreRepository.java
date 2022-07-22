package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Store;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StoreRepository extends JpaRepository<Store, ObjectId> {
    List<Store> findByCompany(ObjectId id);
}
