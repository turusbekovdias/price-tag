package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.PriceTagDTO;
import kz.datcom.pricetag.model.PriceTag;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class PriceTagMapper {

    public PriceTagDTO toDTO(PriceTag priceTag) {
        PriceTagDTO tagDTO = new PriceTagDTO();
        tagDTO.setId(priceTag.getId());
        tagDTO.setTagCode(priceTag.getTagCode());
        tagDTO.setBaseStation(priceTag.getBaseStation());
        tagDTO.setStatus(priceTag.getStatus());
        tagDTO.setRegistrationDate(priceTag.getRegistrationDate());
        tagDTO.setProductItem(priceTag.getItem());
        return tagDTO;
    }

    public PriceTag toEntity (PriceTagDTO priceTagDTO) {
        PriceTag tagEnt = new PriceTag();
        tagEnt.setId(priceTagDTO.getId());
        tagEnt.setItem(priceTagDTO.getProductItem());
        tagEnt.setTagCode(priceTagDTO.getTagCode());
        tagEnt.setBaseStation(priceTagDTO.getBaseStation());
        tagEnt.setStatus(priceTagDTO.getStatus());
        tagEnt.setRegistrationDate(priceTagDTO.getRegistrationDate());
        return tagEnt;
    }

    public List<PriceTag> toEntity(List<PriceTagDTO> dtoList) {
        return dtoList.stream()
                .map(env -> {
                    return toEntity(env);
                })
                .collect(Collectors.toList());
    }

    public List <PriceTagDTO> toDTO(List<PriceTag> entityList) {
        return entityList.stream()
                .map(env -> {
                    return toDTO(env);
                })
                .collect(Collectors.toList());
    }

}
