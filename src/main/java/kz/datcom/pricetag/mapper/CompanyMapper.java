package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.BaseStationDTO;
import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.model.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {

    CompanyDTO toDTO(Company company);

    Company toEntity (CompanyDTO companyDTO);

    List<Company> toEntity(List<CompanyDTO> dtoList);

    List <CompanyDTO> toDTO(List<Company> entityList);
}
