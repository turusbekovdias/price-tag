package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.BaseStationDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BaseStationService {

    BaseStationDTO addBaseStation (BaseStationDTO stationDTO);
    BaseStationDTO getBaseStation (Long id);
    BaseStationDTO editBaseStation (BaseStationDTO stationDTO);
    List<BaseStationDTO> stationList ();
    List<BaseStationDTO> stationByStore(Long storeId);
    Void deleteStation (Long id) throws Exception;

}
