package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.StoreDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StoreService {

    Mono<StoreDTO> addBranch (StoreDTO branchDTO);
    Mono<StoreDTO> editBranch (StoreDTO branchDTO);
    Flux<StoreDTO> branchList (ObjectId id);
    Mono<StoreDTO> getBranch (ObjectId id);
    Mono<Void> deleteBranch (StoreDTO branchDTO);

}
