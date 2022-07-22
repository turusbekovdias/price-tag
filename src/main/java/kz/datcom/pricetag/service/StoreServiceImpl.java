package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.mapper.StoreMappper;
import kz.datcom.pricetag.model.Store;
import kz.datcom.pricetag.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {

    @Autowired
    StoreRepository storeRepository;

    private final StoreMappper storeMapper;

    @Override
    public StoreDTO addStore(StoreDTO storeDTO) {
        Store store = storeRepository.save(storeMapper.toEntity(storeDTO));
        return storeMapper.toDTO(store);
    }

    @Override
    public StoreDTO editStore(StoreDTO storeDTO) {
        return null;
    }

    @Override
    public List<StoreDTO> storeList(ObjectId companyId) {
        List<Store> stores = storeRepository.findByCompany(companyId);
        return storeMapper.toDTO(stores);
    }

    @Override
    public StoreDTO getStore(ObjectId id) {
        Store store = storeRepository.getOne(id);
        return storeMapper.toDTO(store);
    }

    @Override
    public Void deleteStore(ObjectId id) throws Exception{
        try {
            storeRepository.deleteById(id);
            return null;
        } catch (Exception ex) {
            throw ex;
        }
    }
}
