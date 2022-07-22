package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.AccessTokenDTO;
import kz.datcom.pricetag.dto.AccountLoginDTO;
import kz.datcom.pricetag.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    @PostMapping(value = "/login", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> loginCEO(@RequestBody AccountLoginDTO client) {
        try {
            if (client.getLogin() == null || client.getPassword() == null) {
                throw new Exception("Логин && Пароль");
            }
            AccessTokenDTO accessTokenDTO = accountService.authentication(client);
            return ResponseEntity.ok(accessTokenDTO);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
