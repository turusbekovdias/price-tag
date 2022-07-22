package kz.datcom.pricetag.model;

import org.bson.types.ObjectId;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "base_station")
public class BaseStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private ObjectId id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany
    private List<PriceTag> priceTags;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<PriceTag> getPriceTags() {
        return priceTags;
    }

    public void setPriceTags(List<PriceTag> priceTags) {
        this.priceTags = priceTags;
    }
}
