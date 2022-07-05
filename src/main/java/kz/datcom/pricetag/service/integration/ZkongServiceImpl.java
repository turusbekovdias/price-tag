package kz.datcom.pricetag.service.integration;

import kz.datcom.pricetag.dto.AuthDTO;
import kz.datcom.pricetag.dto.ImportItemDTO;
import kz.datcom.pricetag.dto.ZkongResponceDTO;
import kz.datcom.pricetag.model.TagItemBind;
import reactor.core.publisher.Mono;

import java.util.List;

public class ZkongServiceImpl implements ZkongService{

    @Override
    public Mono<ZkongResponceDTO> getPublicKey() {
        return null;
    }

    @Override
    public Mono<ZkongResponceDTO> signIn(AuthDTO authDTO) {
        return null;
    }

    @Override
    public Mono<ZkongResponceDTO> importItem(ImportItemDTO importItemDTO) {
        return null;
    }

    @Override
    public Mono<ZkongResponceDTO> deleteItem(String storeId, List<String> items) {
        return null;
    }

    @Override
    public Mono<ZkongResponceDTO> tagItemBinds(List<TagItemBind> tagItemBindList) {
        return null;
    }
}
