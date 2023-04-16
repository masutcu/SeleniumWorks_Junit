package day18_ScreenShot_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C04_ExtendReportTest extends TestBase {
    /*
        EXTENTREPORT kullanabilmemiz için;
            1-pom.xml dosyasına extentreports dependency'si eklenir
            2-ExtentReports class'ından bir obje oluşturulur
            3-HTML formatında düzenleneceği için ExtentHtmlReporter class'ından obje oluşturulur
            4-Rapora test ile ilgili bilgiler girebilmek için ExtentTest class'ından bir obje oluşturulur
         */
    ExtentReports extentReports; //Raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz
    @Test
    public void extentReportTest() {
        extentReports = new ExtentReports();
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
        extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
        extentReports.attachReporter(extentHtmlReporter);

        //Raporda gözükmesini istediğimiz bilgiler için
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","MehmetAli");
        extentHtmlReporter.config().setDocumentTitle("ExtentReport");
        extentHtmlReporter.config().setReportName("SmokeTest Raporu");
        extentTest=extentReports.createTest("ExtentTest", "Test Raporu");

        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Amazon sayfasında iphone araması yapıldı");
        WebElement sonucYazisi=driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        System.out.println(sonucYazisi.getText());
        extentTest.pass("sayfa kapatıldı");

        extentReports.flush();
    }
}
