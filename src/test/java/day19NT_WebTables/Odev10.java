package day19NT_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Odev10 extends TestBase {
    //https://www.selenium.dev/downloads/ adresine gidelim
    //Sayfanın resmini alalım
    //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
    //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
    //Documentation webelementinin resmini alalım
    //All versions available in Downloads altında Latest stable release olan linki tıklayalım
    //Açılan pencerede chromedriver'i indirelim
    //Driver'in indiğini doğrulayalım
    //İndirmiş olduğumuz dosyayı silelim
    //Silindiğini doğrulayalım
    //Not: Bu task'in her adımı için Html rapor oluşturalım(Extent Report)

    ExtentReports extentReports; //Raporlamayı başlatır
    ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz
    @Test
    public void extentReportTest() throws IOException, InterruptedException {
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

        driver.get("https://www.selenium.dev/downloads/");

        String w1Handle=driver.getWindowHandle();
        extentTest.info("Selenium dev sayfasına gidildi");

        //ilk olarak dosyayı nereye kaydedeceğimizi belirtiriz.
        String dosyaYoluScreenShot="TestOutput/screenShot.png"; //proje seviyesinden new directory diyerek resimler için klasör açalım.
        //2. Adım TakesScreenshot arayüzünden obje oluşturmak
        TakesScreenshot ts= (TakesScreenshot) driver;
        //3. adım
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYoluScreenShot));
        extentTest.info("sayfanın resmi alındı");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions=new Actions(driver);
        WebElement hedef=driver.findElement(By.xpath("//div[@id='platforms-supported-by-selenium']"));
        actions.scrollToElement(hedef).perform();
        Thread.sleep(2000);
        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("//*[@class='btn btn-dark btn-lg btn-block rounded-0 text-left collapsed']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@href='https://chromedriver.chromium.org/']")).click();

        //Documentation webelementinin resmini alalım
        Set<String> wHandles=driver.getWindowHandles();

        for (String w:wHandles){
            if(!w.equals(w1Handle)){
                driver.switchTo().window(w);
                TakesScreenshot ts1= (TakesScreenshot) driver;
                FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE),new File(dosyaYoluScreenShot));

            }
        }




    }
}
