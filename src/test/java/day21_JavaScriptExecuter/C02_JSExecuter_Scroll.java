package day21_JavaScriptExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JSExecuter_Scroll extends TestBase {
    @Test
    public void jseScroll() {
        /*
        //Techpro education ana sayfasına git
        //We Offer elementi görünür olacak şekilde üzerine scroll et ve ekran görüntüsünü al
        //Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al
        //Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        //Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        */
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapattık

        WebElement weOffer=driver.findElement(By.xpath("//span[text()='we offer']"));
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);", weOffer);

        //scrollByJavaSc(weOffer);//oluşturduğumuz method ile

        tumSayfaResmi();
        bekle(3);

        //Aynı sayfada Enroll Free elementi görünür olacak sekilde scroll et ve ekran görüntüsünü al

        WebElement enrollFree = driver.findElement(By.xpath("//span[.='Enroll Free Course']"));
        scrollByJavaSc(enrollFree);
        webElementResmi(enrollFree);

        //Aynı sayfada WHY US? elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al
        WebElement whyUs=driver.findElement(By.xpath("//h3[.='WHY US?']"));
        tumSayfaResmi();
        bekle(3);

        //Aynı sayfada tekrar Enroll Free elementi görünür olacak şekilde scroll et ve ekran görüntüsünü al

        scrollByJavaSc(enrollFree);
        webElementResmi(enrollFree);
        bekle(3);

        //sayfayı en alta kaydır
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        bekle(3);
        //scrollEndByJc(); oluşturduğumuz method ile

        //sayfa başına methodla gidelim
        scrollTopByJc();








    }
}
