package day20_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ExcelRead {
/*
        DİKKAT :ÖNCE AŞAĞIDAKİ DEPENDANCY pom.xml e ekledik
        <!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi-ooxml</artifactId>
            <version>5.2.3</version>
        </dependency>
 */

    //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
    //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
    //Kullanılan satır sayısın bulun
    //Ülke-Başkent şeklinde verileri yazdırın


    @Test
    public void readExcelTest() throws IOException {
        //Dosyayı aç
        FileInputStream file = new FileInputStream("src/test/java/resources/Capitals.xlsx");

        //FileInputStream objesini WorkBook(Excel) dosyası olarak aç.
        Workbook workbook = WorkbookFactory.create(file);

        //sayfayı aç
        Sheet sheet1 = workbook.getSheet("Sheet1");

        //satıra git
        Row row = sheet1.getRow(0);//1. satır imdex 0 dır.

        //birinci hücreyi al
        Cell cell = row.getCell(0);
        System.out.println("cell = " + cell);

        //Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        Cell cell12 = sheet1.getRow(0).getCell(1);
        System.out.println("cell1 = " + cell12);

        //3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Cell cell31 = sheet1.getRow(2).getCell(0);
        System.out.println("cell31 = " + cell31);
        Assert.assertEquals("France", cell31.toString());

        //Kullanılan satır sayısın bulun
        int sonkullanilanSatirSayisi = sheet1.getLastRowNum();//son satırın index nosunu verir Toplam satır +1 dir
        System.out.println("toplam satır sayısı = " + (sonkullanilanSatirSayisi + 1));
        //veya
        int toplamKullanilansatirsayisi = sheet1.getPhysicalNumberOfRows();
        System.out.println("toplamKullanilansatirsayisi = " + toplamKullanilansatirsayisi);

        //Ülke-Başkent şeklinde verileri yazdırın
        Map<String, String> ulkelerVeBaskentleri = new LinkedHashMap<>();//HashMap olsaydı rastgele sıralardı, bu şekilde insertion order
        ulkelerVeBaskentleri.put("Fraance", "Paris");
        System.out.println(ulkelerVeBaskentleri); //{Fraance=Paris}

        for (int satirIndex = 1; satirIndex <= sonkullanilanSatirSayisi; satirIndex++) {
            String ulkeadi = sheet1.getRow(satirIndex).getCell(0).toString();
            String baskent = sheet1.getRow(satirIndex).getCell(1).toString();

            ulkelerVeBaskentleri.put(ulkeadi, baskent);

        }System.out.println(ulkelerVeBaskentleri);
    }
}
