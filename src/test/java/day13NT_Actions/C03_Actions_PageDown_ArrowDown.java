package day13NT_Actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions_PageDown_ArrowDown extends TestBase {
    @Test
    public void test(){

     //https://techproeducation.com adresine gidin
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
     //Sayfanın alt tarafına gidin
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).perform();

     //Sayfanın üst tarafına gidin
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();


    }

}
