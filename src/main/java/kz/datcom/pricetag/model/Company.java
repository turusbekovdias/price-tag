package kz.datcom.pricetag.model;

import org.bson.types.ObjectId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private ObjectId id;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany
    private List<Store> stores;

    @OneToMany
    private List<BaseStation> baseStations;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<BaseStation> getBaseStations() {
        return baseStations;
    }

    public void setBaseStations(List<BaseStation> baseStations) {
        this.baseStations = baseStations;
    }
}