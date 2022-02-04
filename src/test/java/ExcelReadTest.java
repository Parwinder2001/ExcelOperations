import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReadTest {
    public static  void  main(String args[]) throws IOException {
        System.out.println(System.getProperty("user.dir"));
        FileInputStream fi=new FileInputStream("C:\\Users\\LUCKY\\IdeaProjects\\ExcelOperations\\TestSheetData.xlsx");
        XSSFWorkbook wb=new XSSFWorkbook(fi);
        XSSFSheet sheet=wb.getSheetAt(0);
        int row=sheet.getLastRowNum();

        int cols=sheet.getRow(1).getLastCellNum();
        System.out.println(row);
        System.out.println(cols);
        for (int i=0;i<=row;i++){
            for (int j=0;j<=cols-1;j++){
                System.out.println(sheet.getRow(i).getCell(j).getStringCellValue());
            }
        }
        //System.out.println(sheet.getRow(1).getCell(0).getStringCellValue());

    }
}
