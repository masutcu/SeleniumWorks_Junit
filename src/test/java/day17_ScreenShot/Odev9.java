package day17_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class Odev9 extends TestBase {
    /*
    //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sayfasına gidelim
    //Click me, to open an alert after 5 seconds butonuna basalım
    //Çıkan alert'i kapatalım
     */

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.id("alert")).click();
        //1. yol
        //Thread.sleep(5000);
        //driver.switchTo().alert().accept();
        //2. yol
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        
    }

    @Test
    public void test02() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sitesine gidin
        // 'Enable button after 10 seconds' butonuna tiklayin.
        // 'Button'un tiklanabilir oldugunu test edin.

        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        driver.findElement(By.id("enable-button")).click();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(11));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='disable']")));
        assertTrue(driver.findElement(By.id("disable")).isDisplayed());

    }

    @Test
    public void test03() {
        //https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver sitesine git
        driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
        // 'Check Checkbox after 10 seconds' butonuna tikla
        driver.findElement(By.id("checkbox")).click();
        // 'checkbox' butonunun tiklandigini test edin.
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(11));
        wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
        assertTrue(driver.findElement(By.id("ch")).isSelected());

    }
}
