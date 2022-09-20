package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.mapper.StoreMappper;
import kz.datcom.pricetag.model.Store;
import kz.datcom.pricetag.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

     private StoreMappper storeMapper = new StoreMappper();

    @Override
    public StoreDTO addStore(StoreDTO storeDTO) {
        Store store = storeMapper.toEntity(storeDTO);
        storeRepository.save(store);
        return storeMapper.toDTO(store);
    }

    @Override
    public StoreDTO editStore(StoreDTO storeDTO) {
        return null;
    }

    @Override
    public List<StoreDTO> storesByCompany(Long companyId) {
        List<Store> stores = storeRepository.findByCompany(companyId);
        return storeMapper.toDTO(stores);
    }

    @Override
    public List<StoreDTO> storeList() {
        List<Store> stores = storeRepository.findAll();
        return storeMapper.toDTO(stores);
    }


    @Override
    public StoreDTO getStore(Long id) {
        Store store = storeRepository.getOne(id);
        return storeMapper.toDTO(store);
    }

    @Override
    public Void deleteStore(Long id) throws Exception{
        try {
            storeRepository.deleteById(id);
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
