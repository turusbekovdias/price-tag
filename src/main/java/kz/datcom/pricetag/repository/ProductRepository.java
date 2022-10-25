package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Item, Long> {

    Item findByBarCode(String barCode);
    List<Item> findByStatus(String status);

}
