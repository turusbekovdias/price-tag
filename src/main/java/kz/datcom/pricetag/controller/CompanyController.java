package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.CompanyDTO;
import kz.datcom.pricetag.dto.StoreDTO;
import kz.datcom.pricetag.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @PostMapping(value = "/add/company", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> addCompany(@RequestBody CompanyDTO companyDTO) {
        try {
            return ResponseEntity.ok(companyService.addCompany(companyDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{companyId}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> deleteCompany(@PathVariable ObjectId companyId) {
        try {
            return ResponseEntity.ok(companyService.deleteCompany(companyId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/company/list", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getCompanyList() {
        try {
            return ResponseEntity.ok(companyService.companyList());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getById(@PathVariable ObjectId companyId) {
        try {
            return ResponseEntity.ok(companyService.getCompany(companyId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
