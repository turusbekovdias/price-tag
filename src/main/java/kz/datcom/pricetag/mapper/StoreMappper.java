package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.model.Company;
import kz.datcom.pricetag.model.Store;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StoreMappper {

    StoreDTO toDTO(Store store);

    Store toEntity (StoreDTO storeDTO);

    List<Store> toEntity(List<StoreDTO> dtoList);

    List <StoreDTO> toDTO(List<Store> entityList);

}
