package kz.datcom.pricetag.dto;

import lombok.Data;

@Data
public class AccountLoginDTO {

    private String login;
    private String password;
    private Long loginType;

}
