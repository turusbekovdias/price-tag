package kz.datcom.pricetag.service.integration;

import kz.datcom.pricetag.dto.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZkongService {

    ZkongResponseDTO signIn (AuthDTO authDTO) throws Exception;
    ZkongResponseDTO importItem () throws Exception;
    ZkongResponseDTO deleteItem(List<String> list) throws Exception;
    ZkongResponseDTO tagItemBinds() throws Exception;
}
