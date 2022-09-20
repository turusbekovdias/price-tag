package kz.datcom.pricetag.repository;

import kz.datcom.pricetag.model.Account;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findAccountByLogin(String login);
}
