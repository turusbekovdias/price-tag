package kz.datcom.pricetag.service;

import kz.datcom.pricetag.dto.AccessTokenDTO;
import kz.datcom.pricetag.dto.AccountLoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    AccessTokenDTO authentication(AccountLoginDTO client);

}
