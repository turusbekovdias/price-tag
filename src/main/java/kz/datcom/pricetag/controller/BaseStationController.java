package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.service.BaseStationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/base_station")
public class BaseStationController {

    private final BaseStationService baseStationService;

    public Mono<BaseStationDTO> addBaseStation () {
        return baseStationService.
    }

    public Mono<BaseStationDTO> editBaseStation() {
        return baseStationService.
    }

    public Mono<Void> deleteBaseStation() {
        return baseStationService.
    }


}
