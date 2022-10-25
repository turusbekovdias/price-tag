package kz.datcom.pricetag.service.excel;

import kz.datcom.pricetag.dto.ImportItemDTO;
import kz.datcom.pricetag.dto.ItemDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.io.File;
import java.util.List;

@Service
public interface ReadExcelService {

    List<ItemDTO> readFile (MultipartFile file) throws Exception;
    Boolean saveItems(List<ItemDTO> items) throws Exception;
}
