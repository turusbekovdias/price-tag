package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.mapper.CompanyMapper;
import kz.datcom.pricetag.model.Company;
import kz.datcom.pricetag.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService{

    @Autowired
    CompanyRepository companyRepository;

    private final CompanyMapper companyMapper;

    @Override
    public CompanyDTO addCompany(CompanyDTO companyDTO) {
        Company company = companyRepository.save(companyMapper.toEntity(companyDTO));
        return companyMapper.toDTO(company);
    }

    @Override
    public CompanyDTO editCompany(CompanyDTO companyDTO) {
        return null;
    }

    @Override
    public List<CompanyDTO> companyList() {

        List<Company> companies = (List<Company>) companyRepository.findAll();
        return companyMapper.toDTO(companies);

    }

    @Override
    public CompanyDTO getCompany(ObjectId id) throws Exception {
        try {
            Company company = companyRepository.findById(id);
            return companyMapper.toDTO(company);
        } catch(Exception ex) {
            throw ex;
        }
    }

    @Override
    public Void deleteCompany(ObjectId id) {
        companyRepository.deleteById(id);
        return null;
    }
}
