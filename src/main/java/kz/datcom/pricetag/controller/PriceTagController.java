package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.PriceTagDTO;
import kz.datcom.pricetag.service.PriceTagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/price-tags")
public class PriceTagController {

    private final PriceTagService priceTagService;

    @PostMapping(value = "/add/tag", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> addPriceTag(@RequestBody PriceTagDTO priceTagDTO) {
        try {
            return ResponseEntity.ok(priceTagService.addPriceTag(priceTagDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{tagId}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> deletePriceTag(@PathVariable ObjectId tagId) {
        try {
            return ResponseEntity.ok(priceTagService.deleteTag(tagId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/tag/list", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getTagList(@RequestParam("storeId") ObjectId storeId) {
        try {
            return ResponseEntity.ok(priceTagService.tagList(storeId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getById(@PathVariable ObjectId tagId) {
        try {
            return ResponseEntity.ok(priceTagService.getPriceTag(tagId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


}
