package kz.datcom.pricetag.service.integration;

import kz.datcom.pricetag.dto.*;
import kz.datcom.pricetag.model.TagItemBind;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ZkongService {

    ZkongResponceDTO getPublicKey();
    ZkongResponceDTO signIn (AuthDTO authDTO);
    ZkongResponceDTO importItem (ImportItemDTO importItemDTO);
    ZkongResponceDTO deleteItem(DeleteItemDTO deleteItemDTO);
    ZkongResponceDTO tagItemBinds(TagsItemsBindDTO tagsItemsBindDTO);
}
