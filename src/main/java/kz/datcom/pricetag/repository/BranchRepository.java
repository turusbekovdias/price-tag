package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Store;
import org.bson.types.ObjectId;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface BranchRepository extends ReactiveCrudRepository<Store, ObjectId> {
}
