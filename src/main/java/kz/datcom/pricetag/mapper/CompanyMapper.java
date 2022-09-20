package kz.datcom.pricetag.mapper;


import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.model.Company;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyMapper {

    public CompanyDTO toDTO(Company company) {
        CompanyDTO dto = new CompanyDTO();
        dto.setId(company.getId());
        dto.setCountry(company.getCountry());
        dto.setStatus(company.getStatus());
        dto.setRegistrationDate(company.getRegistrationDate());
        dto.setCompanyName(company.getCompanyName());
        return dto;
    }

    public Company toEntity (CompanyDTO companyDTO) {
        Company dto = new Company();
        dto.setId(companyDTO.getId());
        dto.setCountry(companyDTO.getCountry());
        dto.setStatus(companyDTO.getStatus());
        dto.setRegistrationDate(companyDTO.getRegistrationDate());
        dto.setCompanyName(companyDTO.getCompanyName());
        return dto;
    };

    public List<Company> toEntity(List<CompanyDTO> dtoList) {
       return dtoList.stream()
               .map(env -> {
                   Company company = new Company();
                   company.setId(env.getId());
                   company.setCompanyName(env.getCompanyName());
                   company.setCountry(env.getCountry());
                   company.setStatus(env.getStatus());
                   company.setRegistrationDate(env.getRegistrationDate());
                   return company;
               })
               .collect(Collectors.toList());
    }

    public List<CompanyDTO> toDTO(List<Company> entityList) {
        return entityList.stream()
                .map(env -> {
                    CompanyDTO company = new CompanyDTO();
                    company.setId(env.getId());
                    company.setCompanyName(env.getCompanyName());
                    company.setCountry(env.getCountry());
                    company.setStatus(env.getStatus());
                    company.setRegistrationDate(env.getRegistrationDate());
                    return company;
                })
                .collect(Collectors.toList());
    }
}
