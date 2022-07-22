package kz.datcom.pricetag.model;

import javax.persistence.*;

@Entity
@Table(name = "price_tag")
public class PriceTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @Column(name = "tag_code")
    private String tagCode;


    @ManyToOne
    @JoinColumn(name = "base_station_id")
    private BaseStation baseStation;

}
