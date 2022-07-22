package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.mapper.BaseStationMapper;
import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.repository.BaseStationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BaseStationServiceImpl implements BaseStationService {

    @Autowired
    public BaseStationRepository baseStationRepository;

    private final BaseStationMapper baseStationMapper;

    @Override
    public BaseStationDTO addBaseStation(BaseStationDTO stationDTO) {
        BaseStation baseStation = baseStationRepository.save(baseStationMapper.toEntity(stationDTO));
        return baseStationMapper.toDTO(baseStation);
    }

    @Override
    public BaseStationDTO getBaseStation(ObjectId id) {
        BaseStation baseStation = baseStationRepository.getOne(id);
        return baseStationMapper.toDTO(baseStation);
    }
    @Override
    public BaseStationDTO editBaseStation(BaseStationDTO baseStationDTO) {
        return null;
    }

    @Override
    public List<BaseStationDTO> stationList(ObjectId id) {
        List<BaseStation> baseStations = baseStationRepository.findByStoreId(id);
        return baseStationMapper.toDTO(baseStations);
    }

    @Override
    public Void deleteStation(ObjectId id) throws Exception {
        try {
            baseStationRepository.deleteById(id);
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
