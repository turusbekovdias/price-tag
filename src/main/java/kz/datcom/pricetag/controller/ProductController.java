package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.ItemDTO;
import kz.datcom.pricetag.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping(value = "/add/product")
    public ResponseEntity addProduct(@RequestBody ItemDTO productDTO) {
        try {
            return ResponseEntity.ok(productService.addProduct(productDTO));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{productId}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> deleteProduct(@PathVariable Long productId) {
        try {
            productService.deleteProduct(productId);
            return ResponseEntity.ok("Product was delete");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping(value = "/product/list",  produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getProductList() {
        try {
            return ResponseEntity.ok(productService.productList());
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body("Что то не так");
        }
    }

    @GetMapping(value = "/{id}", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> getById(@PathVariable Long productId) {
        try {
            return ResponseEntity.ok(productService.getProduct(productId));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
