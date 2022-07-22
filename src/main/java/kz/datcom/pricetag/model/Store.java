package kz.datcom.pricetag.model;

import org.bson.types.ObjectId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "store")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private ObjectId id;

    @ManyToOne
    @Column(name = "company")
    private Company company;

    @Column(name = "store_name")
    private String storeName;

    @OneToMany
    private List<BaseStation> baseStationList;

}
