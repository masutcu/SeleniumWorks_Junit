package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C03_FluentWait extends TestBase {
    /*
https://the-internet.herokuapp.com/dynamic_loading/1
Start buttonuna tıklayın
Hello World! Yazının sitede oldugunu test edin
*/

    @Test
    public void fluentWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
        //Hello World! Yazının sitede oldugunu test edin
        //Fluent wait in WebDriver wait ten farkı wait ojjesinin oluşturulmasında ortaya çıkar.
        Wait<WebDriver> wait=new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).        //Max bekleme süresi
                pollingEvery(Duration.ofSeconds(3)).        //Deneme aralıkları
                withMessage("ıgnore exception").            //Mesaj yazdırılabilir. zorunlu değil
                ignoring(NoSuchMethodException.class);      //Exception handle edilebilir
        WebElement helloWtext= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        assertTrue(helloWtext.isDisplayed());
    }
}
