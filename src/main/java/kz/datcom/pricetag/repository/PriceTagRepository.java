package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.PriceTag;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PriceTagRepository extends ReactiveCrudRepository <PriceTag, String> {
}
