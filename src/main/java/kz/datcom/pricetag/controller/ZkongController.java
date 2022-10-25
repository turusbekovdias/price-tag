package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.AccountLoginDTO;
import kz.datcom.pricetag.dto.AuthDTO;
import kz.datcom.pricetag.dto.ImportItemDTO;
import kz.datcom.pricetag.dto.PriceTagDTO;
import kz.datcom.pricetag.service.PriceTagService;
import kz.datcom.pricetag.service.integration.ZkongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/zkong")
public class ZkongController {

    private final ZkongService zkongService;

    @PostMapping(value = "/auth", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> addPriceTag(@RequestBody AuthDTO authDTO) {
        try {
            return ResponseEntity.ok(zkongService.signIn(authDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/import-items", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> importItems() {
        try {
            return ResponseEntity.ok(zkongService.importItem());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/bind-tags-items", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> bindTagsItems() {
        try {
            return ResponseEntity.ok(zkongService.tagItemBinds());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
