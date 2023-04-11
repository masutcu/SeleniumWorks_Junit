package day14NT_FakerClass_FileExist;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    /*
    "https://techproeducation.com/" gidin
    İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
     */
    @Test
    public void actions(){
        driver.get("https://techproeducation.com/");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        WebElement search=driver.findElement(By.xpath("//*[@type='search']"));
        //İlk kelime SHIFT tuşuna basılı şekilde, ikinci kelime basılmadan "TECHPRO education" araması yapın.
        Actions actions=new Actions(driver);
        actions.keyDown(search, Keys.SHIFT).sendKeys("techpro").
                keyUp(Keys.SHIFT).sendKeys(" education",Keys.ENTER).
                perform();
        bekle(1);

        //sayfayı Richmond collage linkine kadar  scroll yapalım
        WebElement ricmondC=driver.findElement(By.xpath("(//h3//a)[9]"));
        actions.scrollToElement(ricmondC).perform();


    }

}
