package kz.datcom.pricetag.service.integration;

import kz.datcom.pricetag.dto.*;

public class ZkongServiceImpl implements ZkongService{

    @Override
    public ZkongResponceDTO getPublicKey() {
        try {
            ZkongResponceDTO responceDTO = ZkongAPI.getPublicKey();
            return responceDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ZkongResponceDTO signIn(AuthDTO authDTO) {
        try {
            ZkongResponceDTO responceDTO = ZkongAPI.logIn(authDTO);
            return responceDTO;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ZkongResponceDTO importItem(ImportItemDTO importItemDTO) {
        try {
            ZkongResponceDTO responceDTO = ZkongAPI.importItem(importItemDTO);
            return responceDTO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public ZkongResponceDTO deleteItem(DeleteItemDTO deleteItemDTO) {
        try {
            ZkongResponceDTO responceDTO = ZkongAPI.deleteItem(deleteItemDTO);
            return responceDTO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public ZkongResponceDTO tagItemBinds(TagsItemsBindDTO tagsItemsBindDTO) {
        try {
            ZkongResponceDTO responceDTO = ZkongAPI.bindItemWithTag(tagsItemsBindDTO);
            return responceDTO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
