package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.StoreDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StoreService {

    StoreDTO addStore (StoreDTO storeDTO);
    StoreDTO editStore (StoreDTO storeDTO);
    List<StoreDTO> storesByCompany (Long companyId);
    List<StoreDTO> storeList();
    StoreDTO getStore (Long id);
    Void deleteStore (Long id) throws Exception;

}
