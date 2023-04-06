package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class odev1 extends TestBase {

    @Test
    public void  test(){
        driver.get("https://www.singaporeair.com/en_UK/tr/home#/book/bookflight");
        bekle(2);
        //cookies leri kaldırdık
        driver.findElement(By.xpath("//div[text()='Accept essential cookies only']")).click();
        WebElement planTravel=driver.findElement(By.xpath("//*[@href='/en_UK/tr/plan-travel/']"));
        Actions actions=new Actions(driver);
        bekle(2);
        actions.moveToElement(planTravel).perform();
        bekle(1);
        driver.findElement(By.xpath("//*[@href='/en_UK/tr/plan-travel/promotions/hotel/']")).click();


    }
}
