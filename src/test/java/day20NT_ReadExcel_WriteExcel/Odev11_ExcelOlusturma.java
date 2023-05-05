package day20NT_ReadExcel_WriteExcel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

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
    @Test
    public void test01() throws IOException {
        dosyaOlusturma();
        loginTest();
    }
    public void dosyaOlusturma() {
        try {
            // Excel Workbook ve Sheet oluşturun
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sheet1");
            // Satırları oluşturun ve hücrelere veri girin
            Row row1 = sheet.createRow(0);
            Cell cellA1 = row1.createCell(0);
            cellA1.setCellValue("Email");
            Cell cellB1 = row1.createCell(1);
            cellB1.setCellValue("Password");
            //*********************************************
            Row row2 = sheet.createRow(1);
            Cell cellA2 = row2.createCell(0);
            cellA2.setCellValue("evren.techproed@gmail.com");
            Cell cellB2 = row2.createCell(1);
            cellB2.setCellValue("asdfgh");
            //****************************************
            // Dosyayı kaydediyorum
            String userHome = System.getProperty("user.home");
            FileOutputStream fis = new FileOutputStream(userHome + "\\Desktop\\login.xlsx");
            workbook.write(fis);
            workbook.close();
            System.out.println("Dosya başarıyla oluşturuldu.");
        } catch (IOException e) {
            System.out.println("Dosya olusturulamadi.");
        }
    }
    public void loginTest() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//    -İkinci methodda https://www.bluerentalcars.com/ adresine gidip
        driver.get("https://www.bluerentalcars.com");
        driver.findElement(By.xpath("//a[.=' Login']")).click();
//    -Excel dosyasından aldığımız kullanıcı bilgileri ile login olalım
        int cell1 = 1;
        int cell2 = 1;
        String userHome = System.getProperty("user.home");
        String excellDosyasi = userHome + "\\Desktop\\login.xlsx";
        FileInputStream fis = new FileInputStream(excellDosyasi);
        //olusturdugum dosyayi kullanmak icin buraya getirdim!
        Workbook workbook = WorkbookFactory.create(fis);
        //Dosyami Workbook'a atadim.
        String mail = workbook.getSheet("Sheet1").getRow(1).getCell(0).toString();
        String password = workbook.getSheet("Sheet1").getRow(1).getCell(1).toString();
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys(mail);
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password + Keys.ENTER);
//    -Login olduğumuzu doğrulayalım
        String actualResult = driver.findElement(By.xpath("//button[text()='Erol Evren']")).getText();
        String expectedResult = "Erol Evren";
        assertEquals(expectedResult, actualResult);
    }
}
