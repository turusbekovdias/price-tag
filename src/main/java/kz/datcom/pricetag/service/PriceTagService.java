package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.PriceTagDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PriceTagService {
    
    PriceTagDTO addPriceTag (PriceTagDTO tag);
    PriceTagDTO editPriceTag (PriceTagDTO tag);
    PriceTagDTO getPriceTag (Long id);
    List<PriceTagDTO> tagList();
    List<PriceTagDTO> tagByBaseStation(Long id);
    Void deleteTag (Long id);
    
}
