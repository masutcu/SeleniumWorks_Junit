package day06Practice;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {
    //  Ulkeler dosyasındaki 3.satırdaki indexin, 3.sutunundaki indexinin
    // "Cezayir" oldugunu test eden method olusturunuz


    @Test
    public void test01() throws IOException {
        int satirNoIdx=3;
        int sutunNoIdx=3;

        String actualData=banaDataGetir(satirNoIdx,sutunNoIdx);
        System.out.println(actualData);
        String expectedData="Cezayir";
        Assert.assertEquals(expectedData,actualData);




    }
    public String banaDataGetir(int satirNo, int sutunNo) throws IOException {

        String dosyaYolu="src/Recources/ulkeler.xlsx";
        FileInputStream  fis=new FileInputStream(dosyaYolu);//ulkeler dosyasını bizim sistemimize getirdik
        Workbook workbook= WorkbookFactory.create(fis); //dosyayı workbook a atadık
        String istenenData=workbook.getSheet("Sayfa1").getRow(satirNo).getCell(sutunNo).toString();

        return istenenData;

    }


}
