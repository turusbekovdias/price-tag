package kz.datcom.pricetag.factory;

import kz.datcom.pricetag.dto.ItemDTO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadExcelFactory {

    public static List<ItemDTO> takeDataExcel(MultipartFile file) throws Exception {
        try {

            List<ItemDTO> itemDTOs = new ArrayList<>();

            InputStream inputStream = file.getInputStream();
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                ItemDTO item = ItemDTO.builder().build();

                int count = 0;

                while(cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    System.out.println(cell);
                    if (count == 0) {
                        if (String.valueOf(cell).equals("")) {
                            count = -1;
                            break;
                        }
                        item.setBarCode(String.valueOf(cell));
                    } else if (count == 1) {
                        item.setAttrName(String.valueOf(cell));
                    } else if (count == 2) {
                        item.setAttrCategory(String.valueOf(cell));
                    } else if (count == 3) {
                        item.setShortTitle(String.valueOf(cell));
                    } else if (count == 4) {
                        item.setItemTitle(String.valueOf(cell));
                    } else if (count == 5) {
                        item.setPrice(BigDecimal.valueOf(cell.getNumericCellValue()));
                    } else if (count == 6) {
                        item.setOriginalPrice(BigDecimal.valueOf(cell.getNumericCellValue()));
                    } else if (count == 7) {
                        item.setMemberPrice(BigDecimal.valueOf(cell.getNumericCellValue()));
                    }

                    count ++;

                }
                if (count == -1) {
                    break;
                }
                itemDTOs.add(item);
            }

            return itemDTOs;

        } catch (Exception ex) {
            throw ex;
        }
    }

}
