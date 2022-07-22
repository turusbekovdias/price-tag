package kz.datcom.pricetag.dto;

import kz.datcom.pricetag.model.Company;
import kz.datcom.pricetag.model.PriceTag;
import kz.datcom.pricetag.model.Store;
import org.bson.types.ObjectId;

import java.util.List;

public class BaseStationDTO {

    private ObjectId id;
    private Store store;
    private Company company;
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
