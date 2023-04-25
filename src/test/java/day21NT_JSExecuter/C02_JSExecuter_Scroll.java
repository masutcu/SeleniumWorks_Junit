package day21NT_JSExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Scroll extends TestBase {
    JavascriptExecutor js;
    @Test
    public void jsEx_scrollTest() {
        /*
    Techpro education ana sayfasına git
    "We Offer" elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
    Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
    Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
     */
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapattık

        WebElement weOffer= driver.findElement(By.xpath("//*[text()='we offer']"));
        bekle(2);
        js= (JavascriptExecutor) driver; //test üstünde obje oluşturduk
        js.executeScript("arguments[0].scrollIntoView(true);",weOffer);

        //Aynı sayfada "Enroll Free "elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al

        WebElement enrollFree=driver.findElement(By.xpath("//span[text()='Enroll Free Course']"));
        scrollByJavaSc(enrollFree);
        bekle(2);
        tumSayfaResmi();

        //Aynı sayfada "WHY US?" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs = driver.findElement(By.xpath("//*[text()='WHY US?']"));
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",whyUs);
         */
        scrollByJavaSc(whyUs);
        bekle(2);
        tumSayfaResmi();
        //Aynı sayfada tekrar "Enroll Free" elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        /*
        js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",enrollFree);
         */
        scrollByJavaSc(enrollFree);
        bekle(2);
        tumSayfaResmi();

        //sayfayı en alta kaydır
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(3);
        //scrollEndByJc(); oluşturduğumuz method ile

        //Sayfayi en üste scroll yapalım
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        bekle(3);
        //js.executeScript("window.scrollTo(0,-500)"); //500pixcel yukarı
    }





    }

