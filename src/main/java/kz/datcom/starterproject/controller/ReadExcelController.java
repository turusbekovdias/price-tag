package kz.datcom.starterproject.controller;

import kz.datcom.starterproject.service.ReadExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.io.File;

@RestController
@RequiredArgsConstructor
public class ReadExcelController {

   private final ReadExcelService readExcelService;


    @PostMapping(name="")
    Mono<Void> readExcelFile (@RequestBody File file) {
        return readExcelService.readFile(file);
    }

}
