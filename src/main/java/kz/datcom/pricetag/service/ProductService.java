package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.ItemDTO;

import java.util.List;

public interface ProductService {

    ItemDTO addProduct(ItemDTO itemDTO) throws Exception;
    void deleteProduct(Long productId) throws Exception;
    List<ItemDTO> productList() throws Exception;
    ItemDTO getProduct(Long productId) throws Exception;

}
