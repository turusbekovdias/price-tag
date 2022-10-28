package kz.datcom.pricetag.service.excel;

import kz.datcom.pricetag.dto.ImportItemDTO;
import kz.datcom.pricetag.dto.ItemDTO;
import kz.datcom.pricetag.factory.ReadExcelFactory;
import kz.datcom.pricetag.mapper.ProductItemMapper;
import kz.datcom.pricetag.model.Item;
import kz.datcom.pricetag.repository.ProductRepository;
import kz.datcom.pricetag.service.excel.ReadExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReadExcelServiceImpl implements ReadExcelService {

    @Autowired
    ProductRepository productRepository;

    private final ProductItemMapper productItemMapper = new ProductItemMapper();

    @Override
    public List<ItemDTO> readFile(MultipartFile file) throws Exception {
        try {
            List<ItemDTO> items = ReadExcelFactory.takeDataExcel(file);
            List<ItemDTO> importItems = new ArrayList<>();
            for (int i = 0; i < items.size(); i++) {
                Item item = productRepository.findByBarCode(items.get(i).getBarCode());
                if (item == null) {
                    items.get(i).setStatus("NEW");
                    importItems.add(items.get(i));
                } else {
                    item.setStatus("CHANGE");
                    item.setShortTitle(items.get(i).getShortTitle());
                    item.setAttrName(items.get(i).getAttrName());
                    item.setAttrCategory(items.get(i).getAttrCategory());
                    item.setItemTitle(items.get(i).getItemTitle());
                    item.setPrice(items.get(i).getPrice());
                    item.setMemberPrice(items.get(i).getMemberPrice());
                    item.setOriginalPrice(items.get(i).getOriginalPrice());
                    importItems.add(productItemMapper.toDTO(item));
                }
                System.out.println(item);
            }
            return importItems;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private ItemDTO checkItemWithDTO(Item item, ItemDTO dto) {

        dto.setAttrCategory(item.getAttrCategory());
        dto.setAttrName(item.getAttrName());

        return dto;
    }


    @Override
    public Boolean saveItems(List<ItemDTO> items) throws Exception {
        try {
            items.stream()
                    .map(value -> {
                        return productRepository.save(productItemMapper.toEntity(value));
                    }).collect(Collectors.toList());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
