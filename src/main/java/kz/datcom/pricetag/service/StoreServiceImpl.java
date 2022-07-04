package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.StoreDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class StoreServiceImpl implements StoreService {

    @Override
    public Mono<StoreDTO> addBranch(StoreDTO branchDTO) {
        return null;
    }

    @Override
    public Mono<StoreDTO> editBranch(StoreDTO branchDTO) {
        return null;
    }

    @Override
    public Flux<StoreDTO> branchList(ObjectId id) {
        return null;
    }

    @Override
    public Mono<StoreDTO> getBranch(ObjectId id) {
        return null;
    }

    @Override
    public Mono<Void> deleteBranch(StoreDTO branchDTO) {
        return null;
    }
}
