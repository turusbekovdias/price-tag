package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/branch")
public class BranchController {

    private final StoreService branchService;

    public Mono<StoreDTO> addBranch(@RequestBody StoreDTO branchDTO) {
        return branchService.addBranch(branchDTO);
    }

    public Mono<StoreDTO> editBranch(@RequestBody StoreDTO branchDTO) {
        return branchService.editBranch(branchDTO);
    }

    public Flux<StoreDTO> branchList(@RequestParam("id") ObjectId id) {
        return branchService.branchList(id);
    }

    public Mono<StoreDTO> getBranch(@RequestParam("id") ObjectId id) {
        return branchService.getBranch(id);
    }

    public Mono<Void> deleteBranch(@RequestBody StoreDTO branchDTO) {
        return branchService.deleteBranch(branchDTO);
    }

}
