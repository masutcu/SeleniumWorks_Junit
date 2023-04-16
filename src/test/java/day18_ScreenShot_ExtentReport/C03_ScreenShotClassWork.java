package day18_ScreenShot_ExtentReport;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C03_ScreenShotClassWork extends TestBase {
    @Test
    public void classWork() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");

        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        //sayfanın resmini alalım
        bekle(1);
        tumSayfaResmi();
        // Arama bölümünde java aratalım
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("java", Keys.ENTER);
        // ve sonuç yazısının resmini alalım
        WebElement sonucText=driver.findElement(By.xpath("//h1"));
        bekle(2);
        webElementResmi(sonucText);


        // yeni bir sekmede amazona gidelim
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        // sayfanın resmini alalım
        bekle(2);
        tumSayfaResmi();

        // arama bölümünde iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

        ///ve sonuc yazısının resmini alalım
        WebElement sonucYazisi2 = driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]"));
        bekle(2);
        webElementResmi(sonucYazisi2);//Method kullanarak Webelementin resmini aldık

        //tekrar tecpro sayfasına geçelim ve sayfa resmini alalım
        window(0);
        tumSayfaResmi();
    }
}
