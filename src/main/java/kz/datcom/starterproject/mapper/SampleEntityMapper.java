package kz.datcom.starterproject.mapper;

import kz.datcom.starterproject.dto.SampleDTO;
import kz.datcom.starterproject.model.SampleEntity;
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
}
