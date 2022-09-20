package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.service.BaseStationService;
import kz.datcom.pricetag.service.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/stores")
public class BranchController {

    private final StoreService storeService;

    @PostMapping(value = "/add/store", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> addStore(@RequestBody StoreDTO storeDTO) {
        try {
            return ResponseEntity.ok(storeService.addStore(storeDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{storeId}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> deleteStore(@PathVariable Long storeId) {
        try {
            return ResponseEntity.ok(storeService.deleteStore(storeId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/company/list")
    public ResponseEntity<Object> getStoresByCompanyId(@RequestParam("companyId") Long companyId) {
        try {
            return ResponseEntity.ok(storeService.storesByCompany(companyId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


    @GetMapping(value = "/store/list")
    public ResponseEntity<Object> getStoreList() {
        try {
            return ResponseEntity.ok(storeService.storeList());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
    @GetMapping(value = "/{id}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getById(@PathVariable Long storeId) {
        try {
            return ResponseEntity.ok(storeService.getStore(storeId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
