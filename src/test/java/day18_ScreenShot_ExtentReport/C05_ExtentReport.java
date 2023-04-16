package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_ExtentReport extends TestBase {
    @Test
    public void test() {
        extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        driver.get("https://techproeducation.com");
        extentTest.info("Tecproeducation sayfasına gidildi");
        bekle(3);
        extentTest.info("3 saniye bekletildi");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum
        extentTest.info("Çıkan reklam kapatıldı");
        //sayfanın resmini alalım
        tumSayfaResmi();
        extentTest.info("Tüm sayfanın resmi alındı");
        //Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);
        extentTest.info("Arama bölümünde java aratıldı");

        //ve sonuc yazısının resmini alalım
        WebElement sonucYazisi = driver.findElement(By.xpath("//h1"));
        webElementResmi(sonucYazisi);//Method kullanarak Webelementin resmini aldık
        extentTest.info("Sonuc yazısının resmi alındı");
        extentTest.pass("Test sonlandırıldı");


    }

}
