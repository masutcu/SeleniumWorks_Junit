package day13NT_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions_KeysShift extends TestBase {
    @Test
    public void actions() {
        //https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        //Sayfanın üst tarafına gidin
        bekle(2);
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();
    }
    @Test
    public void actions2() {
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();
        //Sayfanın alt tarafına gidin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);
        //Sayfanın üst tarafına gidin
        bekle(4);
        actions.sendKeys(Keys.HOME).build().perform();//perform() ile action objemi işleme alır
        //build() methodu ile birden fazla oluşturduğumuz action objesini birbirine bağlayabilirz
    }
    @Test
    public void actions3() {
        //Amazon anasayfasına gidin
        driver.get("https://amazon.com");
        //Arama kutusunda büyük harflerle samsung aratalım
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys(Keys.SHIFT,"sa",Keys.SHIFT,"msung",Keys.ENTER);//SAmsung
        driver.navigate().back();
        WebElement aramaKutusuu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuu.sendKeys(Keys.SHIFT,"iphone");//IPHONE
    }
}
