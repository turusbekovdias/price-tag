package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.ImportItemDTO;
import kz.datcom.pricetag.service.excel.ReadExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/excel")
public class ReadExcelController {

   private final ReadExcelService readExcelService;

    @PostMapping(value = "/import-items", consumes = "application/json", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<Object> readExcelFile(@RequestBody File file) {
        try {
            ImportItemDTO importItemDTO = readExcelService.readFile(file);
        } catch (Exception ex) {
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }
        return ResponseEntity.ok("Done");
    }
}
