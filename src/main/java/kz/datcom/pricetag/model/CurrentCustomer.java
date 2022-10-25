package kz.datcom.pricetag.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "current_customer")
public class CurrentCustomer {

    @Id
    @NonNull
    @Column(name = "id")
    private Integer id;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "create_time")
    private String createTime;

    @Column(name = "last_login_time")
    private String lastLoginTime;

    @Column(name = "token")
    private String token;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "merchant_name")
    private String merchantName;

    @Column(name = "store_id")
    private String storeId;

    @Column(name = "store_name")
    private String storeName;

    @Column(name = "enable")
    private String enable;

    @Column(name = "flag")
    private String flag;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "department")
    private String department;

    @Column(name = "agency_id")
    private String agencyId;

    @Column(name = "agency_name")
    private String agencyName;

}
