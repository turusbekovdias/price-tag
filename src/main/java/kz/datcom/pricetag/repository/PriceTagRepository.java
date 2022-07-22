package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.PriceTag;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

public interface PriceTagRepository extends JpaRepository<PriceTag, String> {
    List<PriceTag> findByStoreId(ObjectId storeId);
}
