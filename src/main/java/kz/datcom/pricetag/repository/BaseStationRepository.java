package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.BaseStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseStationRepository extends JpaRepository<BaseStation, Long> {
    List<BaseStation> findByStoreId(Long storeId);
}
