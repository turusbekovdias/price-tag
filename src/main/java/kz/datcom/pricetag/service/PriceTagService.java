package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.PriceTagDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PriceTagService {
    
    PriceTagDTO addPriceTag (PriceTagDTO tag);
    PriceTagDTO editPriceTag (PriceTagDTO tag);
    PriceTagDTO getPriceTag (ObjectId id);
    List<PriceTagDTO> tagList (ObjectId storeId);
    Void deleteTag (ObjectId id);
    
}
