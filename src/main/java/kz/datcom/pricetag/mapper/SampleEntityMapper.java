package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.dto.SampleDTO;
import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.model.SampleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

@Mapper(
    unmappedSourcePolicy = ReportingPolicy.IGNORE,
    unmappedTargetPolicy = ReportingPolicy.WARN,
    componentModel = "spring")
public interface SampleEntityMapper extends BaseEntityMapper<SampleDTO, SampleEntity> {
  @Mappings({
    @Mapping(target = "myName", source = "name"),
    @Mapping(target = "myValue", source = "value")
  })
  @Override
  SampleDTO toDTO(final SampleEntity entity);

    BaseStation toEntity(BaseStationDTO baseStationDTO);
}
