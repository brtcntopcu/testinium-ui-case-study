package data;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelData {

    public ExcelData(String FilePath) {
        this.FilePath = FilePath;

    }

    public String FilePath;
    public String getExcelData(int sheetNumber, int rowNumber, int cellNumber) throws IOException {

        FileInputStream file = new FileInputStream(this.FilePath);
        Workbook excel = WorkbookFactory.create(file);
        Sheet sheet = excel.getSheetAt(sheetNumber);
        Row row = sheet.getRow(rowNumber);
        Cell cell = row.getCell(cellNumber);

        return cell.getStringCellValue();
    }
}
