import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriteTest {
    public static  void  main(String args[]) throws IOException {
        FileInputStream fi = new FileInputStream(System.getProperty("user.dir")+"\\TestSheetData.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fi);
        XSSFSheet sheet = wb.getSheetAt(0);
        sheet.getRow(1).getCell(1).setCellValue("trew");
        FileOutputStream fo=new FileOutputStream(System.getProperty("user.dir")+"\\TestSheetData.xlsx");
        wb.write(fo);
        fo.close();
    }
}
