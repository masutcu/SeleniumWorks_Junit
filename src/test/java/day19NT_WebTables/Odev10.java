package day19NT_WebTables;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.time.Duration;
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
        extentHtmlReporter.config().setReportName("Odev10 Raporu");
        extentTest=extentReports.createTest("ExtentTest", "Test Raporu");

        driver.get("https://www.selenium.dev/downloads/");


        extentTest.info("Selenium dev sayfasına gidildi");

        //ilk olarak dosyayı nereye kaydedeceğimizi belirtiriz.
        String dosyaYoluScreenShot="TestOutput/screenShot"+tarih+".png"; //proje seviyesinden new directory diyerek resimler için klasör açalım.

        //2. Adım TakesScreenshot arayüzünden obje oluşturmak
        TakesScreenshot ts= (TakesScreenshot) driver;

        //3. adım
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYoluScreenShot));
        Thread.sleep(2000);
        extentTest.info("ilk sayfanın ekran görüntüsü kaydedildi");

        //Platforms Supported by Selenium altındaki Browsers bölümü görünene kadar sayfayı indirelim
        Actions actions=new Actions(driver);
        WebElement hedef=driver.findElement(By.xpath("//div[@id='platforms-supported-by-selenium']"));
        actions.scrollToElement(hedef).perform();
        extentTest.info("Sayfa istenilen yere kadar kaydırıldı");
        Thread.sleep(2000);
        extentTest.info("2 saniye hard wait");

        //Browser bölümünden Chrome driver bölümündeki documentation linkine tıklıyalım
        driver.findElement(By.xpath("(//i[@class='fas fa-plus show-collapsed pr-2'])[1]")).click();
        extentTest.info("Documantation linki tıklandı");
        Thread.sleep(1000);
        extentTest.info("1 saniye hard wait");
        driver.findElement(By.xpath("//*[@href='https://chromedriver.chromium.org/']")).click();
        extentTest.info("chrome driver documantation linki tıklandı");

        //yeni sayfaya geçtik
        String w1Handle=driver.getWindowHandle();
        extentTest.info("yeni sayfanın handle değeri alındı");

        //Documentation webelementinin resmini alalım

        TakesScreenshot ts1= (TakesScreenshot) driver;
        String tarih1 = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYoluScreenShot1="TestOutput/screenShot"+tarih1+".png";
        FileUtils.copyFile(ts1.getScreenshotAs(OutputType.FILE),new File(dosyaYoluScreenShot1));
        extentTest.info("yeni sayfanın ekran görüntüsü kaydedildi");


        //All versions available in Downloads altında Latest stable release olan linki tıklayalım
        Thread.sleep(2000);
        extentTest.info("2 saniye hard wait");
        driver.findElement(By.xpath("//a[@href='https://chromedriver.storage.googleapis.com/index.html?path=112.0.5615.49/']")).click();
        extentTest.info("Latest stable release olan linki tıklandı");

        //Açılan pencerede chromedriver'i indirelim  bylinktext:"/112.0.5615.49/chromedriver_win32.zip"
        Set<String> wHandles=driver.getWindowHandles();
        System.out.println(wHandles);
       //yeni sayfaya geçebilmek için ilk sayfanın handle değerini loop içinde sorgulatarak diğer sayfaya geçiş sağlıyoruz.
        for (String w:wHandles){
           if(!w.equals(w1Handle)){
               driver.switchTo().window(w);
               driver.findElement(By.xpath("//a[@href='/112.0.5615.49/chromedriver_win32.zip']")).click();

           }
       }
        extentTest.info("yeni sayfadan chrome driver indirildi");

        //WebDriverWait indirmeyiBekle=new WebDriverWait(driver, Duration.ofSeconds(20));
        //indirmeyiBekle.until(ExpectedCondition.) ***DİKKAT başarısız deneme hocaya soralım
        //hard wait kullanıyorum explicitwait ile yapamadım
        Thread.sleep(5000);
        extentTest.info("indirmeyi beklemek için 5 saniye hard wait");

        //Driver'in indiğini doğrulayalım //yolu ==>"C:\Users\Lenovo\Downloads\chromedriver_win32 (1).zip"
        //İndirmiş olduğumuz dosyayı silelim
        //Silindiğini doğrulayalım
        String filePath = System.getProperty("user.home")+"/Downloads/chromedriver_win32 (1).zip";
        boolean isExist = Files.exists(Path.of(filePath));
        Assert.assertTrue(isExist);
        extentTest.info("indirilen dosyanın varlığı doğrulandı");


        //silelim
        File indirilen=new File(filePath);
        indirilen.delete();
        extentTest.info("indirilen dosya silindi");

        //silindiği doğrulayalım
        Assert.assertFalse(Files.exists(Path.of(filePath)));
        extentTest.info("indirilen dosyanın silindiği doğrulandı");

        extentTest.pass("test sonlandırıldı");

        extentReports.flush();

    }
}
