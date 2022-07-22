package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.AccessTokenDTO;
import kz.datcom.pricetag.dto.AccountLoginDTO;
import kz.datcom.pricetag.model.Account;
import kz.datcom.pricetag.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    @Autowired
    private final AccountRepository accountRepository;

    @Override
    public AccessTokenDTO authentication(AccountLoginDTO client) {
        Account account = accountRepository.findAccountByLogin(client.getLogin());
        return new AccessTokenDTO();
    }
}
