package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.BaseStationDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class BaseStationServiceImpl implements BaseStationService {

    @Override
    public Mono<BaseStationDTO> addBaseStation(BaseStationDTO stationDTO) {
        return null;
    }

    @Override
    public Mono<BaseStationDTO> getBaseStation(BaseStationDTO stationDTO) {
        return null;
    }

    @Override
    public Mono<BaseStationDTO> editBaseStation(ObjectId id) {
        return null;
    }

    @Override
    public Flux<BaseStationDTO> stationList() {
        return null;
    }

    @Override
    public Mono<Void> deleteStation(BaseStationDTO stationDTO) {
        return null;
    }
}
