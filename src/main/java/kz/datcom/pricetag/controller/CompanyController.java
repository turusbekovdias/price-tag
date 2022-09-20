package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(value = "/add/company")
    public ResponseEntity addCompany(@RequestBody CompanyDTO companyDTO) {
        try {
            log.info(String.valueOf(companyDTO));
            return ResponseEntity.ok(companyService.addCompany(companyDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{companyId}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> deleteCompany(@PathVariable Long companyId) {
        try {
            return ResponseEntity.ok(companyService.deleteCompany(companyId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/company/list",  produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getCompanyList() {
        try {
            return ResponseEntity.ok(companyService.companyList());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Что то не так");
        }
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getById(@PathVariable Long companyId) {
        try {
            return ResponseEntity.ok(companyService.getCompany(companyId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
