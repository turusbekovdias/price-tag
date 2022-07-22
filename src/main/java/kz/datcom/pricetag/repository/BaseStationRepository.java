package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.BaseStation;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseStationRepository extends JpaRepository<BaseStation, ObjectId> {
    List<BaseStation> findByStoreId(ObjectId storeId);
}
