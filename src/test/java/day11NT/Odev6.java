package day11NT;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Odev6 extends TestBase {
    @Test
    public void test01(){
        // https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/ sitesine gidin
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
// ikinci emojiye tıklayın
        driver.switchTo().frame(1);
        driver.findElement(By.xpath("//a[@href='#nature']")).click();
// tüm ikinci emoji öğelerini yazdırın
        List<WebElement> icons=driver.findElements(By.xpath("//*[@id=\"nature\"]"));
        System.out.println(icons);
        for(WebElement w: icons){
            System.out.println("w.getText() = " + w.getText());
        }
// parent iframe e geri donun
        driver.switchTo().parentFrame();
// formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//input[@id='text']")).sendKeys("<cömcön");
        driver.findElement(By.xpath("//input[@id='smiles']")).sendKeys("kahkf");
        driver.findElement(By.xpath("//input[@id='nature']")).sendKeys("mehvzvmet");
        driver.findElement(By.xpath("//input[@id='food']")).sendKeys("önkAJF");
        driver.findElement(By.xpath("//input[@id='activities']")).sendKeys("JCBAK");
        driver.findElement(By.xpath("//input[@id='places']")).sendKeys("bkscba");
        driver.findElement(By.xpath("//input[@id='objects']")).sendKeys("VKVL");
        driver.findElement(By.xpath("//input[@id='symbols']")).sendKeys("kjbK");
        driver.findElement(By.xpath("//input[@id='flags']")).sendKeys("KAKHBFKB");
        driver.findElement(By.xpath("//input[@id='hide']")).sendKeys("mbjgFJ");
        driver.findElement(By.xpath("//input[@id='active']")).sendKeys("KJBbk");

// apply button a basiniz
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }



}
