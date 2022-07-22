package kz.datcom.pricetag.service.excel;

import kz.datcom.pricetag.dto.ImportItemDTO;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;

@Service
public interface ReadExcelService {

    ImportItemDTO readFile (File file) throws Exception;

}
