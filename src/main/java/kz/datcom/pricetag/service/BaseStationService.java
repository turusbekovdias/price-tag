package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.BaseStationDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BaseStationService {

    Mono<BaseStationDTO> addBaseStation (BaseStationDTO stationDTO);
    Mono<BaseStationDTO> getBaseStation (BaseStationDTO stationDTO);
    Mono<BaseStationDTO> editBaseStation (ObjectId id);
    Flux<BaseStationDTO> stationList ();
    Mono<Void> deleteStation (BaseStationDTO stationDTO);

}
