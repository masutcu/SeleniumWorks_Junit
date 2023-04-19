package day20NT_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void test() throws IOException {


    /*
        Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        Kullanılan satır sayısın bulun
        Ülke-Başkent şeklinde verileri yazdırın
         */
        //Excel dosyasından bir veri almamız için
        // 1-önce dosya yolunu alırız.
        String dosyaYolu = "src/test/java/resources/Capitals.xlsx";

        //2-Dosyayı okuyabilmek için akışa almam gerekir
        FileInputStream fis = new FileInputStream(dosyaYolu);

        //3-Java ortamında bir excel dosyası oluşturmam gerekli
        Workbook workbook = WorkbookFactory.create(fis);//creat fis ile excel de bu dosyayı okuruz

        //4-Sayfayı seçmemiz gerekir
        Sheet sheet = workbook.getSheet("Sheet1");

        //5-satır seçmeliyiz
        Row row = sheet.getRow(0); //Excel de index 0 dan başlar.

        //6- hücreyi seçmemiz gerekir
        Cell cell = row.getCell(0);

        //7- yazdıralım
        System.out.println(cell);

    }

    //7 adımı 3 adıma indirelim

    @Test
    public void test02() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println("1. satır 1. sutun = "
                + workbook.getSheet("Sheet1").getRow(0).getCell(0));
        //bir string e assign etse idik sona toString() metodu kullanmamız gerekirdi
        //String satir1sutun1 = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();

    }

    @Test
    public void test03() throws IOException {
        //1. satır 2 sutunu yazdıralım
        FileInputStream fis = new FileInputStream("src/test/java/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println("1. satır 2. sutun = "
                + workbook.getSheet("Sheet1").getRow(0).getCell(1));
        //3. satır 1. sutun
        System.out.println("3. satır 1. sutun = "
                + workbook.getSheet("Sheet1").getRow(2).getCell(0));
        //France olduğunu test edelim
        Assert.assertEquals("France", workbook.getSheet("Sheet1").getRow(2).getCell(0).toString());

        //Kullanılan satır sayısın bulun
        System.out.println("Kullanılan Satir Sayisi = " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        //Excel tablosunda kullanılan satir sayisini getPhysicalNumberOfRows() methodu ile alabiliriz
        System.out.println("Son Satir Sayisi = " + workbook.getSheet("Sheet1").getLastRowNum());
        //Excel tablosundaki son satır sayısını getSheet("Sheet1") yani sayfayı belirledikten sonra getLastRowNum()
        //methodu ile alabiliriz
        System.out.println("Son Sütun Sayısı = " + workbook.getSheet("Sheet1").getRow(1).getLastCellNum());
        System.out.println("Kullanılan Sütun Sayisi = " + workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells());
        //Ülke-Başkent şeklinde verileri yazdırın
        Map<String, String> ulkeVeBaskenler = new HashMap<>();
        for (int index = 1; index < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); index++) {
            String ulke = workbook.getSheet("Sheet1").getRow(index).getCell(0).toString();
            String basken = workbook.getSheet("Sheet1").getRow(index).getCell(1).toString();
            ulkeVeBaskenler.put(ulke, basken + "\n");
        }
        System.out.println("Ulke ve Baskenler = " + ulkeVeBaskenler);


    }

    @Test
    public void readExcelTest4() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/resourses/Capitals (2).xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        //Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }

    }
}