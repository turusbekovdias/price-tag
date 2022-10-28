package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.DeleteItemDTO;
import kz.datcom.pricetag.dto.ItemDTO;
import kz.datcom.pricetag.dto.ZkongResponseDTO;
import kz.datcom.pricetag.mapper.ProductItemMapper;
import kz.datcom.pricetag.model.Item;
import kz.datcom.pricetag.repository.ProductRepository;
import kz.datcom.pricetag.service.integration.ZkongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    private ProductItemMapper productItemMapper = new ProductItemMapper();

    @Autowired
    ZkongService zkongService;

    @Override
    public ItemDTO addProduct(ItemDTO itemDTO) throws Exception {
        try {
            itemDTO.setStatus("NOT IMPORT");
            Item item = productRepository.save(productItemMapper.toEntity(itemDTO));
            return productItemMapper.toDTO(item);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void deleteProduct(Long productId) {
        try {
            Optional<Item> item = productRepository.findById(productId);
            if (item.get().getStatus().equals("IMPORT")) {
                List<String> list = new ArrayList<>();
                list.add(item.get().getBarCode());
                ZkongResponseDTO responseDTO = zkongService.deleteItem(list);
                if (responseDTO.getSuccess().equals(true)) {
                    productRepository.deleteById(productId);
                }
            } else {
            productRepository.deleteById(productId);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<ItemDTO> productList() throws Exception {
        try {
            List<Item> items = productRepository.findAll();
            return productItemMapper.toDTOs(items);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public ItemDTO getProduct(Long productId) {
        return null;
    }
}
