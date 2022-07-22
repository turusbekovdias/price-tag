package kz.datcom.pricetag.service.excel;

import kz.datcom.pricetag.dto.ImportItemDTO;
import kz.datcom.pricetag.factory.ReadExcelFactory;
import kz.datcom.pricetag.service.excel.ReadExcelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.File;

@Service
@RequiredArgsConstructor
public class ReadExcelServiceImpl implements ReadExcelService {

    @Override
    public ImportItemDTO readFile(File file) throws Exception {
        try {
            ReadExcelFactory.takeDataExcel(file);
            return new ImportItemDTO();
        } catch (Exception ex) {
            throw ex;
        }
    }
}
