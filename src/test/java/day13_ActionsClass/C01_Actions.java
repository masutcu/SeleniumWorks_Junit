package day13_ActionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v109.domsnapshot.model.StringIndex;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
     /*
//https://the-internet.herokuapp.com/context_menu  sitesine gidin
//Kutuya sağ tıklayın
//Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
//Tamam diyerek alert'i kapatın
 */
    @Test
    public void actionsTest(){
        //https://the-internet.herokuapp.com/context_menu  sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //Kutuya sağ tıklayın

        //1. adım Actions objesi oluştur
        Actions actions=new Actions(driver);
        //2. adım üzerinde işlem yapılacak web elementi locate edin
        WebElement kutu=driver.findElement(By.id("hot-spot"));
        //3. adım işlemi uygulayın
        actions.contextClick(kutu).perform();
        //Alert'te cikan yazinin "You selected a context menu" oldugunu test edin
        String textAlart=driver.switchTo().alert().getText();
        String expectedData="You selected a context menu";
        Assert.assertEquals(expectedData,textAlart);
        //Tamam diyerek alert'i kapatın
        driver.switchTo().alert().accept();

    }
}
