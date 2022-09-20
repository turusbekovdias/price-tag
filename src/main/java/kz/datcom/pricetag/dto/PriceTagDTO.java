package kz.datcom.pricetag.dto;

import kz.datcom.pricetag.model.BaseStation;
import kz.datcom.pricetag.model.Store;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
public class PriceTagDTO {

    private Long Id;
    private String tagCode;
    private BaseStation baseStation;
    private LocalDateTime registrationDate;
    private String status;
}
