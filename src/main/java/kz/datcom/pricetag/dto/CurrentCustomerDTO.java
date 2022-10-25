package kz.datcom.pricetag.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrentCustomerDTO {

    private Integer id;
    private String account;
    private String password;
    private Integer roleId;
    private String createTime;
    private String lastLoginTime;
    private String token;
    private String merchantId;
    private String merchantName;
    private String storeId;
    private String storeName;
    private String enable;
    private String flag;
    private String name;
    private String phone;
    private String email;
    private String department;
    private String agencyId;
    private String agencyName;

}
