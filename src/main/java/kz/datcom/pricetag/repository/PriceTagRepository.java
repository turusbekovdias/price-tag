package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.model.PriceTag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import java.util.List;

public interface PriceTagRepository extends JpaRepository<PriceTag, Long> {
    List<PriceTag> findAllByBaseStation(BaseStation station);
    List<PriceTag> findAllByStatus(String status);
}
