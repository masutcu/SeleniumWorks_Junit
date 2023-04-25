package day20NT_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite extends TestBase {
    @Test
    public void excelWriteTest1() throws IOException {
        /*
    Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
    (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
     */
        FileInputStream fis = new FileInputStream("src/test/java/resourses/Capitals (2).xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Excel de bir veri yazdırabilmek için createCell() methodu kullanılır ve hücre içine yazdıracağımız değer için
        //setSellValue() methodu kullanılır
        workbook.getSheet("Sheet1").getRow(0).createCell(2).setCellValue("NUFUS");
        workbook.getSheet("Sheet1").getRow(1).createCell(2).setCellValue("712816");
        workbook.getSheet("Sheet1").getRow(2).createCell(2).setCellValue(2161000);
        workbook.getSheet("Sheet1").getRow(3).createCell(2).setCellValue(8982000);
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue(5663000);
        FileOutputStream fos = new FileOutputStream("src/test/java/resourses/Capitals (2).xlsx");
        workbook.write(fos);
    }
    @Test
    public void deleteExcel() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resourses/Capitals (2).xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Bir hücredeki veriyi silmek için
        workbook.getSheet("Sheet1").getRow(4).createCell(2).setCellValue((String) null);
        FileOutputStream fos = new FileOutputStream("src/test/java/resourses/Capitals (2).xlsx");
        workbook.write(fos);
    }
}
