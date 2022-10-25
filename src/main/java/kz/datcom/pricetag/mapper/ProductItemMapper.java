package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.ItemDTO;
import kz.datcom.pricetag.model.Item;

import java.util.List;
import java.util.stream.Collectors;

public class ProductItemMapper {

    public ItemDTO toDTO(Item item) {
        return  ItemDTO.builder()
                .id(item.getId())
                .itemTitle(item.getItemTitle())
                .memberPrice(item.getMemberPrice())
                .nfcUrl(item.getNfcUrl())
                .originalPrice(item.getOriginalPrice())
                .productArea(item.getProductArea())
                .productCode(item.getProductCode())
                .productSku(item.getProductSku())
                .price(item.getPrice())
                .promotionText(item.getPromotionText())
                .qrCode(item.getQrCode())
                .shortTitle(item.getShortTitle())
                .spec(item.getSpec())
                .status(item.getStatus())
                .stock1(item.getStock1())
                .stock2(item.getStock2())
                .stock3(item.getStock3())
                .unit(item.getUnit())
                .attrCategory(item.getAttrCategory())
                .attrName(item.getAttrName())
                .barCode(item.getBarCode())
                .classLevel(item.getClassLevel())
                .custFeature1(item.getCustFeature1())
                .custFeature2(item.getCustFeature2())
                .custFeature3(item.getCustFeature3())
                .custFeature4(item.getCustFeature4())
                .custFeature5(item.getCustFeature5())
                .custFeature6(item.getCustFeature6())
                .custFeature7(item.getCustFeature7())
                .custFeature8(item.getCustFeature8())
                .custFeature9(item.getCustFeature9())
                .custFeature10(item.getCustFeature10())
                .custFeature11(item.getCustFeature11())
                .custFeature12(item.getCustFeature12())
                .custFeature13(item.getCustFeature13())
                .custFeature14(item.getCustFeature14())
                .custFeature15(item.getCustFeature15()).build();
    }

    public Item toEntity(ItemDTO itemDTO) {

        return  Item.builder()
                .id(itemDTO.getId())
                .itemTitle(itemDTO.getItemTitle())
                .memberPrice(itemDTO.getMemberPrice())
                .nfcUrl(itemDTO.getNfcUrl())
                .originalPrice(itemDTO.getOriginalPrice())
                .productArea(itemDTO.getProductArea())
                .productCode(itemDTO.getProductCode())
                .productSku(itemDTO.getProductSku())
                .price(itemDTO.getPrice())
                .promotionText(itemDTO.getPromotionText())
                .qrCode(itemDTO.getQrCode())
                .shortTitle(itemDTO.getShortTitle())
                .spec(itemDTO.getSpec())
                .status(itemDTO.getStatus())
                .stock1(itemDTO.getStock1())
                .stock2(itemDTO.getStock2())
                .stock3(itemDTO.getStock3())
                .unit(itemDTO.getUnit())
                .attrCategory(itemDTO.getAttrCategory())
                .attrName(itemDTO.getAttrName())
                .barCode(itemDTO.getBarCode())
                .classLevel(itemDTO.getClassLevel())
                .custFeature1(itemDTO.getCustFeature1())
                .custFeature2(itemDTO.getCustFeature2())
                .custFeature3(itemDTO.getCustFeature3())
                .custFeature4(itemDTO.getCustFeature4())
                .custFeature5(itemDTO.getCustFeature5())
                .custFeature6(itemDTO.getCustFeature6())
                .custFeature7(itemDTO.getCustFeature7())
                .custFeature8(itemDTO.getCustFeature8())
                .custFeature9(itemDTO.getCustFeature9())
                .custFeature10(itemDTO.getCustFeature10())
                .custFeature11(itemDTO.getCustFeature11())
                .custFeature12(itemDTO.getCustFeature12())
                .custFeature13(itemDTO.getCustFeature13())
                .custFeature14(itemDTO.getCustFeature14())
                .custFeature15(itemDTO.getCustFeature15()).build();

    }

    public List<ItemDTO> toDTOs (List<Item> items) {
        return items.stream()
                .map(item -> {
                    return toDTO(item);
                })
                .collect(Collectors.toList());
    }

    public List<Item> toEntities(List<ItemDTO> itemDTOs) {

        return itemDTOs.stream()
                .map(itemDTO -> {
                    return toEntity(itemDTO);
                })
                .collect(Collectors.toList());

    }

}
