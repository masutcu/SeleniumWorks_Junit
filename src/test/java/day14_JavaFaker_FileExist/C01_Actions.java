package day14_JavaFaker_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.security.Key;

public class C01_Actions extends TestBase {
    /*
    "https://techproeducation.com/" gidin
    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
 */
    @Test
    public void actionsTest(){
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapatıyoruz
        WebElement aramaBox=driver.findElement(By.xpath("//input[@name='s']"));
        Actions actions=new Actions(driver);
        actions.keyDown(aramaBox,Keys.SHIFT).sendKeys("techpro").
                keyUp(Keys.SHIFT).sendKeys(" education"+Keys.ENTER).
                build().perform();

    }
}
