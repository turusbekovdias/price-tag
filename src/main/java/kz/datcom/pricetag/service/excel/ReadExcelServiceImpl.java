package kz.datcom.pricetag.service.excel;

import kz.datcom.pricetag.service.excel.ReadExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ReadExcelServiceImpl implements ReadExcelService {

    @Override
    public Mono<Void> readFile(File file) {
        return null;
    }
}
