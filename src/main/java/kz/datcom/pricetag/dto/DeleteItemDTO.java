package kz.datcom.pricetag.dto;

import lombok.Data;

import java.util.List;

@Data
public class DeleteItemDTO {
    private String storeId;
    private List<String> list;
}
