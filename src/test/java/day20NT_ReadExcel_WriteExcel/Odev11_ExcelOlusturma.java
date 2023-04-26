package day20NT_ReadExcel_WriteExcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utilities.TestBase;

import java.io.FileOutputStream;
import java.io.IOException;

public class Odev11_ExcelOlusturma extends TestBase {
    /*
    -İki tane test methodu oluşturalım
    -İlkinde masaüstünde java ile data.xlsx isimli bir dosya oluşturalım
    -Birinci satır birinci hücreye email ve ikinci hücreye password
    -ikinci satır birinci hücreye evren.techproed@gmail.com ve ikinci hücreye asdfgh yazdıralım
    -Dosyayı kaydedelim
    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
    -Login olduğumuzu doğrulayalım
*/

        public static void main(String[] args) {

            // Yeni bir Excel dosyası oluştur
            XSSFWorkbook workbook = new XSSFWorkbook();

            // Yeni bir çalışma sayfası oluştur
            XSSFSheet sheet = workbook.createSheet("Sayfa1");

            // Yeni bir satır oluştur
            Row row = sheet.createRow(0);

            // Yeni bir hücre oluştur ve "Hello World!" yaz
            Cell cell = row.createCell(0);
            cell.setCellValue("Hello World!");

            // Dosyayı kaydet
            try (FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.home") + "/Desktop/data.xlsx")) {
                workbook.write(outputStream);
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
