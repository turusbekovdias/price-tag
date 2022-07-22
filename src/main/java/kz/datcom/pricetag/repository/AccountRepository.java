package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Account;
import org.bson.types.ObjectId;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, ObjectId> {
    Account findAccountByLogin(String login);
}
