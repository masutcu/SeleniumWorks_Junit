package day13_ActionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions3 extends TestBase {

 //https://techproeducation.com adresine gidin
 //Sayfanın alt tarafına gidin
 //Sayfanın üst tarafına gidin
    @Test
    public void actions3(){
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapatıyoruz

        Actions actions=new Actions(driver);
        bekle(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);
        actions.sendKeys(Keys.ARROW_DOWN).perform(); //ArrowDown tuşu daha az kaydırıyor
        bekle(3);
        //method zinciri ile Method Chain
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).perform();
        bekle(3);
        actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.ARROW_UP).perform();

    }

}
