package kz.datcom.pricetag.dto;

import kz.datcom.pricetag.model.Item;
import lombok.Data;

import java.util.List;

@Data
public class ImportItemDTO {
    private Long storeId;
    private Long merchantId;
    private Long agencyId;
    private Integer unitName;
    private List<ItemForImportDTO> itemList;
}
