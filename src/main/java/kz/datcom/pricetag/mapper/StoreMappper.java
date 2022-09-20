package kz.datcom.pricetag.mapper;

import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.model.Company;
import kz.datcom.pricetag.model.Store;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class StoreMappper {

    public StoreDTO toDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setCountry(store.getCountry());
        storeDTO.setCompany(store.getCompany());
        storeDTO.setCity(store.getCity());
        storeDTO.setRegistrationDate(store.getRegistrationDate());
        storeDTO.setStoreAddress(store.getStoreAddress());
        storeDTO.setStoreStatus(store.getStoreStatus());
        return storeDTO;
    }

    public Store toEntity (StoreDTO storeDTO) {
            Store store = new Store();
            store.setId(storeDTO.getId());
            store.setCountry(storeDTO.getCountry());
            store.setCompany(storeDTO.getCompany());
            store.setCity(storeDTO.getCity());
            store.setRegistrationDate(storeDTO.getRegistrationDate());
            store.setStoreAddress(storeDTO.getStoreAddress());
            store.setStoreStatus(storeDTO.getStoreStatus());
            return store;
    }

    public List<Store> toEntity(List<StoreDTO> dtoList) {
        return dtoList.stream()
                .map(env -> {
                    Store store = new Store();
                    store.setId(env.getId());
                    store.setCountry(env.getCountry());
                    store.setCompany(env.getCompany());
                    store.setCity(env.getCity());
                    store.setRegistrationDate(env.getRegistrationDate());
                    store.setStoreAddress(env.getStoreAddress());
                    store.setStoreStatus(env.getStoreStatus());
                    return store;
                })
                .collect(Collectors.toList());
    }

    public List <StoreDTO> toDTO(List<Store> entityList) {
        return entityList.stream()
                .map(env -> {
                    StoreDTO storeDTO = new StoreDTO();
                    storeDTO.setId(env.getId());
                    storeDTO.setCountry(env.getCountry());
                    storeDTO.setCompany(env.getCompany());
                    storeDTO.setCity(env.getCity());
                    storeDTO.setRegistrationDate(env.getRegistrationDate());
                    storeDTO.setStoreAddress(env.getStoreAddress());
                    storeDTO.setStoreStatus(env.getStoreStatus());
                    return storeDTO;
                })
                .collect(Collectors.toList());
    }

}
