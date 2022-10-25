package kz.datcom.pricetag.controller;

import kz.datcom.pricetag.dto.ItemDTO;
import kz.datcom.pricetag.service.excel.ReadExcelService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.File;
import java.util.List;


@Slf4j
@Transactional
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/v1/excel")
public class ReadExcelController {

   private final ReadExcelService readExcelService;

    @PostMapping(value = "/import-items", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> readExcelFile(@RequestPart("file") MultipartFile file) {
        try {
            List<ItemDTO> itemDTOs = readExcelService.readFile(file);
            return ResponseEntity.ok(itemDTOs);
        } catch (Exception ex) {
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping(value = "/save-imports")
    public ResponseEntity<Object> saveImportItems(@RequestBody List<ItemDTO> items) {
        try {
            return ResponseEntity.ok(readExcelService.saveItems(items));
        } catch (Exception ex) {
            return  ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

}
