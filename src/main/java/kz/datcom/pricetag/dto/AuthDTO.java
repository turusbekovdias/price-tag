package kz.datcom.pricetag.dto;

import lombok.Data;

@Data
public class AuthDTO {

    private String account;
    private String password;
    private Integer loginType;
}
