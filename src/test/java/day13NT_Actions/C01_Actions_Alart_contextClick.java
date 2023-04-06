package day13NT_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions_Alart_contextClick extends TestBase {
    /*
    https://the-internet.herokuapp.com/context_menu  sitesine gidin
    Kutuya sağ tıklayın
    Alert’te cikan yazinin “You selected a context menu” oldugunu test edin
    Tamam diyerek alert’i kapatın
     */
    @Test
    public void test1(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        bekle(2);
        WebElement kutu=driver.findElement(By.id("hot-spot"));
        Actions actions=new Actions(driver);
        actions.contextClick(kutu).perform();//Actions objesi ile sağ klik methodu olan context click methodunu kullanırız.
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals("You selected a context menu",alertText);

        driver.switchTo().alert().accept();


    }

}
