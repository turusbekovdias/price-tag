package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.dto.PriceTagDTO;
import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.service.BaseStationService;
import kz.datcom.pricetag.service.PriceTagService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/base_station")
public class BaseStationController {

    private final BaseStationService baseStationService;

    @PostMapping(value = "/add/station", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> addBaseStation(@RequestBody BaseStationDTO baseStationDTO) {
        try {
            return ResponseEntity.ok(baseStationService.addBaseStation(baseStationDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{stationId}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> deleteBaseStation(@PathVariable ObjectId stationId) {
        try {
            return ResponseEntity.ok(baseStationService.deleteStation(stationId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/station/list", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getStationList(@RequestParam("storeId") ObjectId storeId) {
        try {
            return ResponseEntity.ok(baseStationService.stationList(storeId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getById(@PathVariable ObjectId stationId) {
        try {
            return ResponseEntity.ok(baseStationService.getBaseStation(stationId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }


}
