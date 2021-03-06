package kz.datcom.pricetag.factory;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

public class ReadExcelFactory {

    public static void takeDataExcel(File file) throws Exception{
        try {

            FileInputStream inputStream = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);

            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();

                while(cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();

                    if (cell.getBooleanCellValue()) {
                        ///
                    }

                }
            }

        } catch (Exception ex) {
            throw ex;
        }
    }

}
