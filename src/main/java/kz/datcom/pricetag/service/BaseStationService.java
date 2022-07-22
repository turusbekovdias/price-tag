package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.BaseStationDTO;
import org.bson.types.ObjectId;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface BaseStationService {

    BaseStationDTO addBaseStation (BaseStationDTO stationDTO);
    BaseStationDTO getBaseStation (ObjectId id);
    BaseStationDTO editBaseStation (BaseStationDTO stationDTO);
    List<BaseStationDTO> stationList (ObjectId storeId);
    Void deleteStation (ObjectId id) throws Exception;

}
