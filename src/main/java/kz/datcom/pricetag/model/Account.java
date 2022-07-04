package kz.datcom.pricetag.model;

import org.bson.types.ObjectId;

import java.util.List;

public class Account {

    private ObjectId id;
    private String fio;
    private String phoneNumber;
    private String email;
    private Role role;
    private List<Store> storeList;

}
