package day15NT_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utilities.TestBase;

import java.time.Duration;

public class C03_FluentWait extends TestBase {
    @Test
    public void fluentWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
        //Hello World! Yazının sitede oldugunu test edin
        Wait<WebDriver> wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(30)).//Fluent wait için max. süreyi belirtir
                        pollingEvery(Duration.ofSeconds(3)).//Her üç saniyede bir webelementi kontrol eder
                        withMessage("Ignore Exeption").//zorunlu değil
                        ignoring(NoSuchElementException.class);//zorunlu değil.Exception'ı handle eder
        WebElement helloWordText1 = driver.findElement(By.xpath("(//h4)[2]"));
        wait.until(ExpectedConditions.visibilityOf(helloWordText1));
        Assert.assertTrue(helloWordText1.isDisplayed());
    }
}
