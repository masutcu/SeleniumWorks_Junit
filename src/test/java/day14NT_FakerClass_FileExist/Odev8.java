package day14NT_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Odev8 extends TestBase {
    /*
    -https://jqueryui.com/slider/#colorpicker adrese gidiniz
-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
-Sarı olduğunu test edelim
     */

    @Test
    public void test08() throws InterruptedException {
        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");
        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        driver.switchTo().frame(0);
        WebElement red = driver.findElement(By.xpath("//div[@id='red']/span"));
        WebElement green = driver.findElement(By.xpath("//div[@id='green']/span"));
        WebElement blue = driver.findElement(By.xpath("//div[@id='blue']/span"));
        Actions actions = new Actions(driver);
        //açılışta uzaklıklar style="background-color: rgb(255, 141, 60);" kırmızı full, green -96 blue -195
        actions.
                clickAndHold(green).
                moveByOffset(-180, 0).
                release().
                perform();
        bekle(2);
        actions.
                clickAndHold(blue).
                moveByOffset(-70, 0).
                release().
                perform();
        bekle(2);
        actions.
                clickAndHold(green).
                moveByOffset(350, 0).
                release().
                perform();
        //-Sarı olduğunu test edelim
        String actual = driver.findElement(By.xpath("//div[@id='swatch']")).getCssValue("background-color");
        System.out.println(actual);
        String expected="255, 255, 1";
        Assert.assertTrue(actual.contains(expected));
    }
}