package day15NT_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_ExplicitWait extends TestBase {
    @Test
    public void explicitWait() {
        //https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //Start buttonuna tıklayın
        driver.findElement(By.xpath("//button")).click();
        //Hello World! Yazının sitede oldugunu test edin
        WebElement helloWordText = driver.findElement(By.xpath("(//h4)[2]"));

        Assert.assertTrue(helloWordText.isDisplayed());
    }
}
