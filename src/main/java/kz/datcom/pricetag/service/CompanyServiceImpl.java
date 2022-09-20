package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.mapper.CompanyMapper;
import kz.datcom.pricetag.model.Company;
import kz.datcom.pricetag.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    private CompanyMapper companyMapper = new CompanyMapper();

    @Override
    public CompanyDTO addCompany(CompanyDTO companyDTO) throws Exception {
        try {
            Company company = companyRepository.save(companyMapper.toEntity(companyDTO));
            return companyMapper.toDTO(company);
        } catch(Exception ex) {
            log.info(ex.getMessage());
            throw ex;
        }
    }

    @Override
    public List<CompanyDTO> companyList() throws Exception {
        try {
            List<Company> companies = (List<Company>) companyRepository.findAll();
            return companyMapper.toDTO(companies);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public CompanyDTO getCompany(Long id) throws Exception {
        try {
            Optional<Company> company = companyRepository.findById(id);
            return companyMapper.toDTO(company.get());
        } catch(Exception ex) {
            throw ex;
        }
    }

    @Override
    public Void deleteCompany(Long id) {
        companyRepository.deleteById(id);
        return null;
    }
}
