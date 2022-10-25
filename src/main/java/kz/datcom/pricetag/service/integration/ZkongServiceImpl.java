package kz.datcom.pricetag.service.integration;

import kz.datcom.pricetag.dto.*;
import kz.datcom.pricetag.model.CurrentCustomer;
import kz.datcom.pricetag.model.Item;
import kz.datcom.pricetag.model.PriceTag;
import kz.datcom.pricetag.model.TagItemBind;
import kz.datcom.pricetag.repository.CurrentCustomerRepository;
import kz.datcom.pricetag.repository.PriceTagRepository;
import kz.datcom.pricetag.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ZkongServiceImpl implements ZkongService{

    private static final String login = "dias123";
    private static final String password = "dias123";
    private static final Integer loginType = 3;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    PriceTagRepository priceTagRepository;

    @Autowired
    CurrentCustomerRepository customerRepository;

    @Override
    public ZkongResponseDTO signIn(AuthDTO authDTO) throws Exception {
        try {
            ZkongResponseDTO responseDTO = ZkongAPI.logIn(authDTO);
            if (responseDTO.getSuccess().equals(true)) {
                LinkedHashMap<String, Object> data = (LinkedHashMap<String, Object>) responseDTO.getData();
                CurrentCustomerDTO curCustomerDTO = toEntityFromObj(data.get("currentUser"));

                curCustomerDTO.setToken(String.valueOf(data.get("token")));

                CurrentCustomer currentCustomer = toEntityFromDTO(curCustomerDTO);

                customerRepository.save(currentCustomer);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ZkongResponseDTO importItem() throws Exception {
        try {
            AuthDTO authDTO = new AuthDTO();
            authDTO.setPassword(password);
            authDTO.setAccount(login);
            authDTO.setLoginType(loginType);
            
            signIn(authDTO);
            
            CurrentCustomer currentCustomer = customerRepository.findByAccount(login);
            
            List<Item> items = productRepository.findByStatus("NOT IMPORT");
            ImportItemDTO importItemDTO = new ImportItemDTO();
            importItemDTO.setAgencyId(currentCustomer.getAgencyId() == null ? null : Long.valueOf(currentCustomer.getAgencyId()));
            importItemDTO.setMerchantId(currentCustomer.getMerchantId() == null ? null : Long.valueOf(currentCustomer.getMerchantId()));
            importItemDTO.setStoreId(currentCustomer.getStoreId() == null ? null : Long.valueOf(currentCustomer.getStoreId()));
            importItemDTO.setItemList(toItemImportDTO(items));
            ZkongResponseDTO responseDTO = ZkongAPI.importItem(importItemDTO, currentCustomer.getToken());

            if (responseDTO.getSuccess().equals(true)) {
                items.stream()
                        .forEach(value -> {
                            value.setStatus("IMPORT");
                            productRepository.save(value);
                        });
            }

            return responseDTO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public ZkongResponseDTO deleteItem(List<String> list) throws Exception {
        try {
            AuthDTO authDTO = new AuthDTO();
            authDTO.setPassword(password);
            authDTO.setAccount(login);
            authDTO.setLoginType(loginType);

            signIn(authDTO);

            CurrentCustomer currentCustomer = customerRepository.findByAccount(login);

            DeleteItemDTO deleteItemDTO = new DeleteItemDTO();
            deleteItemDTO.setList(list);
            deleteItemDTO.setStoreId("1657187081177");


            ZkongResponseDTO responseDTO = ZkongAPI.deleteItem(deleteItemDTO, currentCustomer.getToken());
            return responseDTO;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public ZkongResponseDTO tagItemBinds() throws Exception {
        try {
            AuthDTO authDTO = new AuthDTO();
            authDTO.setPassword(password);
            authDTO.setAccount(login);
            authDTO.setLoginType(loginType);

            signIn(authDTO);

            CurrentCustomer currentCustomer = customerRepository.findByAccount(login);

            List<PriceTag> priceTags = priceTagRepository.findAllByStatus("NOT BIND");
            TagsItemsBindDTO bindDTO = new TagsItemsBindDTO();

            List<TagItemBind> tagItemBinds = priceTags.stream()
                    .map(val -> {
                        TagItemBind tagItemBind = new TagItemBind();
                        tagItemBind.setItemBarcode(val.getItem().getBarCode());
                        tagItemBind.setEslBarcode(val.getTagCode());
                        return tagItemBind;
                    })
                    .collect(Collectors.toList());

            bindDTO.setStoreId("1657187081177");
            bindDTO.setTagItemBinds(tagItemBinds);
            ZkongResponseDTO responseDTO = ZkongAPI.bindItemWithTag(bindDTO, currentCustomer.getToken());

            if (responseDTO.getSuccess().equals(true)) {
                priceTags.stream()
                        .forEach(value -> {
                            value.setStatus("BIND");
                            priceTagRepository.save(value);
                        });
            }

            return responseDTO;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }


    private CurrentCustomer toEntityFromDTO(CurrentCustomerDTO customerDTO) {
        CurrentCustomer currentCustomer = CurrentCustomer.builder()
                .id(customerDTO.getId())
                .account(customerDTO.getAccount())
                .agencyId(customerDTO.getAgencyId())
                .agencyName(customerDTO.getAgencyName())
                .createTime(customerDTO.getCreateTime())
                .department(customerDTO.getDepartment())
                .email(customerDTO.getEmail())
                .enable(customerDTO.getEnable())
                .flag(customerDTO.getFlag())
                .name(customerDTO.getName())
                .lastLoginTime(customerDTO.getLastLoginTime())
                .merchantId(customerDTO.getMerchantId())
                .merchantName(customerDTO.getMerchantName())
                .password(customerDTO.getPassword())
                .phone(customerDTO.getPhone())
                .roleId(customerDTO.getRoleId())
                .storeId(customerDTO.getStoreId())
                .storeName(customerDTO.getStoreName())
                .token(customerDTO.getToken())
                .build();

        return currentCustomer;
    }

    private CurrentCustomerDTO toEntityFromObj(Object data) {
        LinkedHashMap<String, Object> customerResponse = (LinkedHashMap<String, Object>) data;
        CurrentCustomerDTO currentCustomer = CurrentCustomerDTO.builder()
                .account(String.valueOf(customerResponse.get("account")))
                .agencyId(String.valueOf(customerResponse.get("agencyId")))
                .agencyName(String.valueOf(customerResponse.get("agencyName")))
                .createTime(String.valueOf(customerResponse.get("createTime")))
                .department(String.valueOf(customerResponse.get("department")))
                .email(String.valueOf(customerResponse.get("email")))
                .enable(String.valueOf(customerResponse.get("enable")))
                .flag(String.valueOf(customerResponse.get("flag")))
                .id((Integer) customerResponse.get("id"))
                .lastLoginTime(String.valueOf(customerResponse.get("lastLoginTime")))
                .merchantId(String.valueOf(customerResponse.get("merchantId")))
                .merchantName(String.valueOf(customerResponse.get("merchantName")))
                .name(String.valueOf(customerResponse.get("name")))
                .password(String.valueOf(customerResponse.get("password")))
                .phone(String.valueOf(customerResponse.get("phone")))
                .roleId((Integer) customerResponse.get("roleId"))
                .storeId((String) customerResponse.get("storeId"))
                .storeName(String.valueOf(customerResponse.get("storeName")))
                .token(String.valueOf(customerResponse.get("token")))
                .build();

        return currentCustomer;
    }

    private List<ItemForImportDTO> toItemImportDTO(List<Item> items) {
        return items.stream()
                .map(value -> {
                    return ItemForImportDTO.builder()
                            .attrCategory(value.getAttrCategory())
                            .custFeature9(value.getCustFeature9())
                            .attrName(value.getAttrName())
                            .barCode(value.getBarCode())
                            .classLevel(value.getClassLevel())
                            .custFeature13(value.getCustFeature13())
                            .custFeature1(value.getCustFeature1())
                            .custFeature2(value.getCustFeature2())
                            .custFeature3(value.getCustFeature3())
                            .custFeature4(value.getCustFeature4())
                            .custFeature5(value.getCustFeature5())
                            .custFeature6(value.getCustFeature6())
                            .custFeature7(value.getCustFeature7())
                            .custFeature8(value.getCustFeature8())
                            .custFeature10(value.getCustFeature10())
                            .custFeature11(value.getCustFeature11())
                            .custFeature12(value.getCustFeature12())
                            .custFeature14(value.getCustFeature14())
                            .custFeature15(value.getCustFeature15())
                            .itemTitle(value.getItemTitle())
                            .memberPrice(value.getMemberPrice() == null ? null : value.getMemberPrice().toBigInteger())
                            .nfcUrl(value.getNfcUrl())
                            .originalPrice(value.getOriginalPrice() == null ? null : value.getOriginalPrice().toBigInteger())
                            .price(value.getPrice() == null ? null : value.getPrice().toBigInteger())
                            .productArea(value.getProductArea())
                            .productCode(value.getProductCode())
                            .productSku(value.getProductSku())
                            .promotionText(value.getPromotionText())
                            .qrCode(value.getQrCode())
                            .shortTitle(value.getShortTitle())
                            .spec(value.getSpec())
                            .stock1(value.getStock1() == null ? null : value.getStock1().toBigInteger())
                            .stock2(value.getStock2() == null ? null : value.getStock2().toBigInteger())
                            .stock3(value.getStock3() == null ? null : value.getStock3().toBigInteger())
                            .unit(value.getUnit())
                            .build();
                })
                .collect(Collectors.toList());
    }
}