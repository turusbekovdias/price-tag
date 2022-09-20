package kz.datcom.pricetag.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private String country;
    private String companyName;
    private LocalDateTime registrationDate;
    private String status;
}
