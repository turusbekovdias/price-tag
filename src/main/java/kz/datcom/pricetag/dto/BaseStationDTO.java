package kz.datcom.pricetag.dto;

import kz.datcom.pricetag.model.Company;
import kz.datcom.pricetag.model.PriceTag;
import kz.datcom.pricetag.model.Store;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
public class BaseStationDTO {
    private Long Id;
    private String ipAddress;
    private String status;
    private LocalDateTime registrationDate;
    private Store store;
}
