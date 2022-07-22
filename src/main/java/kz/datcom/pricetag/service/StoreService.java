package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.StoreDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface StoreService {

    StoreDTO addStore (StoreDTO storeDTO);
    StoreDTO editStore (StoreDTO storeDTO);
    List<StoreDTO> storeList (ObjectId companyId);
    StoreDTO getStore (ObjectId id);
    Void deleteStore (ObjectId id) throws Exception;

}
