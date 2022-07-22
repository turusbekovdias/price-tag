package kz.datcom.pricetag.dto;

import kz.datcom.pricetag.model.Item;

import java.util.List;

public class ImportItemDTO {
    private Integer storeId;
    private Integer merchantId;
    private Integer agencyId;
    private Integer unitName;
    private List<Item> itemList;
}
