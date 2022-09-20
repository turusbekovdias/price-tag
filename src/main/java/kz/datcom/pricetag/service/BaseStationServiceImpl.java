package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.mapper.BaseStationMapper;
import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.repository.BaseStationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BaseStationServiceImpl implements BaseStationService {

    @Autowired
    BaseStationRepository baseStationRepository;

    private BaseStationMapper baseStationMapper = new BaseStationMapper();

    @Override
    public BaseStationDTO addBaseStation(BaseStationDTO stationDTO) {
        BaseStation baseStation = baseStationRepository.save(baseStationMapper.toEntity(stationDTO));
        return baseStationMapper.toDTO(baseStation);
    }

    @Override
    public BaseStationDTO getBaseStation(Long id) {
        BaseStation baseStation = baseStationRepository.getOne(id);
        return baseStationMapper.toDTO(baseStation);
    }
    @Override
    public BaseStationDTO editBaseStation(BaseStationDTO baseStationDTO) {
        return null;
    }

    @Override
    public List<BaseStationDTO> stationByStore(Long id) {
        List<BaseStation> baseStations = baseStationRepository.findByStoreId(id);
        return baseStationMapper.toDTO(baseStations);
    }

    @Override
    public List<BaseStationDTO> stationList() {
        List<BaseStation> baseStations = baseStationRepository.findAll();
        return baseStationMapper.toDTO(baseStations);
    }

    @Override
    public Void deleteStation(Long id) throws Exception {
        try {
            baseStationRepository.deleteById(id);
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
