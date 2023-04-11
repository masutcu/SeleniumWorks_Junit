package day15_FileUpload_Waits;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class C02_ExplicitWait extends TestBase {
    /*
https://the-internet.herokuapp.com/dynamic_loading/1
Start buttonuna tıklayın
Hello World! Yazının sitede oldugunu test edin
*/
    @Test
    public void explicitWaitTest() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//div[@id='start']/button")).click();
       //Hello World! Yazının sitede oldugunu test edin
        //WebElement helloWtext=driver.findElement(By.xpath("//div[@id='finish']//h4"));
        //implicit ile test geçmedi, explicit wait kullanacağız
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement helloWtext= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
        assertTrue(helloWtext.isDisplayed());


    }
}
