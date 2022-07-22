package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.model.BaseStation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BaseStationMapper {

    BaseStationDTO toDTO(BaseStation baseStation);

    BaseStation toEntity (BaseStationDTO baseStationDTO);

    List<BaseStation> toEntity(List<BaseStationDTO> dtoList);

    List <BaseStationDTO> toDTO(List<BaseStation> entityList);

}
