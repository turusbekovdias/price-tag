package kz.datcom.pricetag.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;

@Data
@Builder
public class ItemForImportDTO {

    private String barCode;
    private String attrCategory;
    private String attrName;
    private String productCode;
    private String productSku;
    private String itemTitle;
    private String shortTitle;
    private String classLevel;
    private String productArea;
    private String unit;
    private String qrCode;
    private String nfcUrl;
    private String spec;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigInteger originalPrice;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigInteger price;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigInteger memberPrice;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigInteger stock1;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigInteger stock2;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    private BigInteger stock3;

    private String promotionText;
    private String custFeature1;
    private String custFeature2;
    private String custFeature3;
    private String custFeature4;
    private String custFeature5;
    private String custFeature6;
    private String custFeature7;
    private String custFeature8;
    private String custFeature9;
    private String custFeature10;
    private String custFeature11;
    private String custFeature12;
    private String custFeature13;
    private String custFeature14;
    private String custFeature15;

}
