package day09_DropDown_Allerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.database.Database;
import utilities.TestBase;

public class C03_Allerts extends TestBase {
    /*
https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
Bir metod olusturun: acceptAlert
1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
Bir metod olusturun: dismissAlert
2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
“successfuly” icermedigini test edin.
Bir metod olusturun: sendKeysAlert
3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
     */

    @Test
    public void acceptAllerts() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
        Thread.sleep(1000);

        driver.switchTo().alert().accept();

        WebElement text=driver.findElement(By.xpath("//p[text()='You successfully clicked an alert']"));
        Assert.assertTrue(text.isDisplayed());


    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(1000);

        driver.switchTo().alert().dismiss();

        String text2=driver.findElement(By.xpath("//p[text()='You clicked: Cancel']")).getText();
        Assert.assertFalse(text2.contains("successfuly"));
    }

    @Test
    public void test3() throws InterruptedException {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Thread.sleep(1000);

        Alert alert=driver.switchTo().alert();
        Thread.sleep(1000);
        alert.sendKeys("mehmet");
        alert.accept();


        WebElement text3=driver.findElement(By.xpath("//*[@id='result']"));
        String isim=text3.getText();
        Assert.assertTrue(isim.contains("mehmet"));
    }
}
