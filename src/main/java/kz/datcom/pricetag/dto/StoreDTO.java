package kz.datcom.pricetag.dto;

import kz.datcom.pricetag.model.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class StoreDTO {

    private Long id;
    private String country;
    private String city;
    private Date registrationDate;
    private String storeAddress;
    private String storeStatus;
    private String image;
    private String description;
    private Company company;
}
