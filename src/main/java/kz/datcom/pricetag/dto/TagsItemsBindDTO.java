package kz.datcom.pricetag.dto;

import kz.datcom.pricetag.model.TagItemBind;
import lombok.Data;

import java.util.List;

@Data
public class TagsItemsBindDTO {

    private String storeId;
    private List<TagItemBind> tagItemBinds;

}
