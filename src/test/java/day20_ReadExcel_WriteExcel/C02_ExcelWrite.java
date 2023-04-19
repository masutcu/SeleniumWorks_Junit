package day20_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_ExcelWrite {
    /*
    Bir "NÜFUS" sütunu oluşturup başkent nüfuslarını excel doyasına yazınız:
    (D.C: 712816, Paris: 2161000, London: 8982000, Ankara: 5663000 ...)
    */

    @Test
    public void excelWriteTest() throws IOException {
        //WorkBook ==> Sheet ==> Row ==> Cell ==> Yaz ==> Kaydet
        Workbook workbook= WorkbookFactory.create(new FileInputStream("src/test/java/resources/Capitals.xlsx"));

        Sheet sheet=workbook.getSheet("sheet1");
        //1 satır 3. sutuna gel
        Cell yenihucreNufus= sheet.getRow(0).createCell(2);
        yenihucreNufus.setCellValue("Nüfus");//şuan memory de yazmadı henüz

        sheet.getRow(1).createCell(2).setCellValue(712816);
        sheet.getRow(2).createCell(2).setCellValue(2161000);
        sheet.getRow(3).createCell(2).setCellValue(8982000);
        sheet.getRow(4).createCell(2).setCellValue(5663000);

        FileOutputStream fileOut=new FileOutputStream("src/test/java/resources/Capitals.xlsx");
        workbook.write(fileOut); //şimdi yazacak


    }
}
