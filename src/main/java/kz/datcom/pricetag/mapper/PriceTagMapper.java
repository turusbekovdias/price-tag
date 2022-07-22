package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.PriceTagDTO;
import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.model.PriceTag;
import kz.datcom.pricetag.model.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceTagMapper {

    PriceTagDTO toDTO(PriceTag priceTag);

    PriceTag toEntity (PriceTagDTO priceTagDTO);

    List<PriceTag> toEntity(List<PriceTagDTO> dtoList);

    List <PriceTagDTO> toDTO(List<PriceTag> entityList);

}
