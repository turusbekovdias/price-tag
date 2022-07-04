package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.BaseStation;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BaseStationRepository extends ReactiveCrudRepository <BaseStation, ObjectId> {
}
