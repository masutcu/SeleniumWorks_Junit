package day06Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_Waits extends TestBase {
    // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
    // Textbox'in etkin olmadıgını(enable) test edin
    // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
    // It's enable! mesajının goruntulendigini test edin
    // Textbox'in etkin oldugunu(enable) test edin

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/dynamic_controls adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // Textbox'in etkin olmadıgını(enable) test edin
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());

        // Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        WebElement enableButton=driver.findElement(By.xpath("(//button[@type='button'])[2]"));
        enableButton.click();

        //Daha fazla bekleme süresi gerektiren belirli elementler için wait kullanılır.
        Wait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        // It's enable! mesajının goruntulendigini test edin
        WebElement mesaj = driver.findElement(By.id("message"));
        Assert.assertTrue(mesaj.isDisplayed());
        // Textbox'in etkin oldugunu(enable) test edin
        Assert.assertTrue(textBox.isEnabled());

    }
}
