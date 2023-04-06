package day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class C02_WindowHandle extends TestBase {
    /*
    https://the-internet.herokuapp.com/windows adresine gidin.
         */
    @Test
    public void windowHandleTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/windows");
        //İlk sayfanın ID'sini alın.
        String window1Handle=driver.getWindowHandle();
        System.out.println("window1 handle kodu : "+window1Handle);
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement window1Text=driver.findElement(By.xpath("//h3"));
        assertEquals("Opening a new window",window1Text.getText());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaBasligi=driver.getTitle();
        assertEquals("The Internet",sayfaBasligi);
        //"Click Here" butonuna tıklayın.
        driver.findElement(By.linkText("Click Here")).click();
        Thread.sleep(3000);
        //Açılan pencereye geçin.
        //bu safhada iki pencere açık 2. pencereye geçiş yapıyorum

        Set<String> allWindowHandels=driver.getWindowHandles();
        System.out.println("allWindowHandels = " + allWindowHandels);
        for(String w:allWindowHandels){
           if(!w.equals(window1Handle)){
               driver.switchTo().window(w);
           }
        }
        String window2Handle=driver.getWindowHandle();

        //Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        Assert.assertEquals("New Window",driver.getTitle());

        //Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(window1Handle);
        assertEquals("The Internet",driver.getTitle());
        Thread.sleep(2000);
        //2. pencereye tekrar geçin.
        driver.switchTo().window(window2Handle);
        Thread.sleep(2000);
        //1. pencereye tekrar dönün.
        driver.switchTo().window(window1Handle);
    }

}
