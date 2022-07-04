package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.PriceTagDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class PriceTagServiceImpl implements PriceTagService {

    @Override
    public Mono<PriceTagDTO> addPriceTag(PriceTagDTO tag) {
        return null;
    }

    @Override
    public Mono<PriceTagDTO> editPriceTag(PriceTagDTO tag) {
        return null;
    }

    @Override
    public Mono<PriceTagDTO> getPriceTag(String id) {
        return null;
    }

    @Override
    public Flux<PriceTagDTO> tagList() {
        return null;
    }

    @Override
    public Mono<Void> deleteTag(PriceTagDTO tag) {
        return null;
    }
}
