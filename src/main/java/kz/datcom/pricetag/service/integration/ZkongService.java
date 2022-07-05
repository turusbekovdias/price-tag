package kz.datcom.pricetag.service.integration;

import kz.datcom.pricetag.dto.AuthDTO;
import kz.datcom.pricetag.dto.ImportItemDTO;
import kz.datcom.pricetag.dto.ZkongResponceDTO;
import kz.datcom.pricetag.model.TagItemBind;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ZkongService {

    Mono<ZkongResponceDTO> getPublicKey();
    Mono<ZkongResponceDTO> signIn (AuthDTO authDTO);
    Mono<ZkongResponceDTO> importItem (ImportItemDTO importItemDTO);
    Mono<ZkongResponceDTO> deleteItem (String storeId, List<String> items);
    Mono<ZkongResponceDTO> tagItemBinds (List<TagItemBind> tagItemBindList);

}
