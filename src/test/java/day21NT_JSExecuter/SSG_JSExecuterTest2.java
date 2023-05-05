package day21NT_JSExecuter;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class SSG_JSExecuterTest2 extends TestBase {
    @Test
    public void name() {
        driver.get("https://amazon.com");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement aramaKutusu = (WebElement) js.executeScript("return document.getElementById('twotabsearchtextbox');");
        aramaKutusu.sendKeys("iphone");
        //WebElement submit = driver.findElement(By.xpath("//*[@type='submit']"));
        WebElement submit = (WebElement) js.executeScript("return document.getElementById('nav-search-submit-button');");
        js.executeScript("arguments[0].click()",submit);
        driver.close();
    }
}