package day15NT_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void explicitWait() {
        /*
        2 temel wait vardir.
        1- Java based wait == Thread.sleep() ---- yani hard wait
        2- Selenium based waits ----- soft wait
            /*
        Implictly Wait: Sayfadaki tüm webelementler için max süre kadar sayfanın yüklemesini bekler
        Explict Wait:
        1-WebDriverWait : Belirli bir koşul gerçekleşene kadar belirttiğimiz süre boyunca driver'ın beklemesini sağlar

        2-Fluent Wait: Belirli bir koşul gerçeklesene kadar belirttiğimiz aralıklarla kontrol ederek beklemeye devam eder.
        mesaj yazdırılabilir ve exception handle edilebilir.
         */


        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
        //Assert.assertTrue(driver.findElement(By.xpath("(//h4)[2]")).isDisplayed());
        //Bir webelementin görünürlüğünü implicitly wait ile bu sayfada çözemedik
        //Hello World! Yazının sitede oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //1.Yol
        /*
        WebElement helloWordText = wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("(//h4)[2]")));
        //visibilityOfElementLocated() webelementin görünür olmasını bekler
         */
        //2.Yol
        WebElement helloWordText1 = driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWordText1));
        Assert.assertTrue(helloWordText1.isDisplayed());
    }
}







