package day16_Exceptions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_TimeOutException extends TestBase {
    @Test
    public void timeOutExceptionTest() {
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//Reklamı kapatıyorum

        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='searchh']")));
        //org.openqa.selenium.TimeoutException: Locater ın yanlış olması sebebiyle ve explicit wait olduğu için locate i süre içinde bulamadı.
    }

    @Test
    public void timeoutExceptionTest2() {


            driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
            driver.findElement(By.xpath("//div[@id='start']//button")).click();
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
            boolean isTrue= wait.until(ExpectedConditions.textToBe(By.xpath("//div[@id='finish']//h4"),"Hello World!"));
            //Locater doğru ama yeterli bekleme süresi olmadığı için timeoutException alıyoruz.
            System.out.println(isTrue);






    }
}
