package kz.datcom.pricetag.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.jfr.Name;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "product_item")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "status")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "station")
    private BaseStation station;

    @Column(unique = true, name = "barcode")
    private String barCode;

    @NonNull
    @Column(name = "attr_category")
    private String attrCategory;

    @NonNull
    @Column(name = "attr_name")
    private String attrName;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_sku")
    private String productSku;

    @Column(name = "item_title")
    private String itemTitle;

    @Column(name = "short_title")
    private String shortTitle;

    @Column(name = "class_level")
    private String classLevel;

    @Column(name = "product_area")
    private String productArea;

    @Column(name = "unit")
    private String unit;

    @Column(name = "qr_code")
    private String qrCode;

    @Column(name = "nfc_url")
    private String nfcUrl;

    @Column(name = "spec")
    private String spec;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column(name = "original_price")
    private BigDecimal originalPrice;

    @JsonFormat(shape= JsonFormat.Shape.STRING)
    @Column(name = "price")
    private BigDecimal price;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column(name = "member_price")
    private BigDecimal memberPrice;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column(name = "stock1")
    private BigDecimal stock1;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column(name = "stock2")
    private BigDecimal stock2;

    @JsonFormat(shape=JsonFormat.Shape.STRING)
    @Column(name = "stock3")
    private BigDecimal stock3;

    @Column(name = "promotion_text")
    private String promotionText;

    @Column(name = "cust_feature1")
    private String custFeature1;

    @Column(name = "cust_feature2")
    private String custFeature2;

    @Column(name = "cust_feature3")
    private String custFeature3;

    @Column(name = "cust_feature4")
    private String custFeature4;

    @Column(name = "cust_feature5")
    private String custFeature5;

    @Column(name = "cust_feature6")
    private String custFeature6;

    @Column(name = "cust_feature7")
    private String custFeature7;

    @Column(name = "cust_feature8")
    private String custFeature8;

    @Column(name = "cust_feature9")
    private String custFeature9;

    @Column(name = "cust_feature10")
    private String custFeature10;

    @Column(name = "cust_feature11")
    private String custFeature11;

    @Column(name = "cust_feature12")
    private String custFeature12;

    @Column(name = "cust_feature13")
    private String custFeature13;

    @Column(name = "cust_feature14")
    private String custFeature14;

    @Column(name = "cust_feature15")
    private String custFeature15;

}
