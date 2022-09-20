package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.model.BaseStation;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public class BaseStationMapper {

    public BaseStationDTO toDTO(BaseStation baseStation) {
        BaseStationDTO stationDTO = new BaseStationDTO();
        stationDTO.setId(baseStation.getId());
        stationDTO.setStatus(baseStation.getStatus());
        stationDTO.setStore(baseStation.getStore());
        stationDTO.setIpAddress(baseStation.getIpAddress());
        stationDTO.setRegistrationDate(baseStation.getRegistrationDate());
        return stationDTO;
    };

    public BaseStation toEntity (BaseStationDTO baseStationDTO) {
        BaseStation station = new BaseStation();
        station.setId(baseStationDTO.getId());
        station.setStatus(baseStationDTO.getStatus());
        station.setStore(baseStationDTO.getStore());
        station.setIpAddress(baseStationDTO.getIpAddress());
        station.setRegistrationDate(baseStationDTO.getRegistrationDate());
        return station;
    }

    public List<BaseStation> toEntity(List<BaseStationDTO> dtoList) {
        return dtoList.stream()
                .map(env -> {
                    BaseStation station = new BaseStation();
                    station.setId(env.getId());
                    station.setStatus(env.getStatus());
                    station.setStore(env.getStore());
                    station.setIpAddress(env.getIpAddress());
                    station.setRegistrationDate(env.getRegistrationDate());
                    return station;
                })
                .collect(Collectors.toList());
    }

    public List<BaseStationDTO> toDTO(List<BaseStation> entityList) {
        return entityList.stream()
                .map(env -> {
                    BaseStationDTO stationDTO = new BaseStationDTO();
                    stationDTO.setId(env.getId());
                    stationDTO.setStatus(env.getStatus());
                    stationDTO.setStore(env.getStore());
                    stationDTO.setIpAddress(env.getIpAddress());
                    stationDTO.setRegistrationDate(env.getRegistrationDate());
                    return stationDTO;
                })
                .collect(Collectors.toList());
    }

}
