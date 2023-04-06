package day09_DropDown_Allerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class Odev5 extends TestBase {
    /*
-http://demo.automationtesting.in/Alerts.html sayfasına gidiniz
-Alert with OK karşısındaki click the button to display an alert box: butonuna tıklayınız
-Çıkan alert üzerindeki yazıyı konsola yazdırınız ve tamam butonuna basınız
-Alert with OK & Cancel butonuna basınız ve sonrasında click the button to display a confirm box butonuna basınız
-Çıkan alert'te iptal butonuna basınız
-Alert with Textbox butonuna basınız ve sonrasında click the button to demonstrate the prompt box butonuna basınız
-Çıkan prompt box'a 'isminizi' yazdırınız ve Tamam'a basınız
-Çıkan mesajı konsola yazdırınız
-Çıkan mesajın 'Hello <isminiz> How are you today' yazdığını doğrulayınız */

    @Test
    public void test1(){
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
        System.out.println("textAlart yazısı = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    @Test
    public void test2(){
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        driver.findElement(By.xpath("//button[@onclick='confirmbox()']")).click();
        driver.switchTo().alert().dismiss();
    }
    @Test
    public void test3() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        driver.findElement(By.xpath("//button[@onclick='promptbox()']")).click();
        driver.switchTo().alert().sendKeys("mehmet ali");
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        String isim=driver.findElement(By.xpath("//p[@id='demo1']")).getText();
        System.out.println("isim = " + isim);
        String expectedName="Hello mehmet ali How are you today";
        Assert.assertTrue(isim.equals(expectedName));
    }

}
