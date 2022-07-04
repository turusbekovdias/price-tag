package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.PriceTagDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PriceTagService {
    
    Mono<PriceTagDTO> addPriceTag (PriceTagDTO tag);
    Mono<PriceTagDTO> editPriceTag (PriceTagDTO tag);
    Mono<PriceTagDTO> getPriceTag (String id);
    Flux<PriceTagDTO> tagList ();
    Mono<Void> deleteTag (PriceTagDTO tag);
    
}
