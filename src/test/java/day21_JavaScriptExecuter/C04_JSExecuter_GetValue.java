package day21_JavaScriptExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecuter_GetValue extends TestBase {
    //  1)getValueTest metotu olustur
    // 2)https://www.priceline.com/ a git
    //  3)Tarih kısmındaki Yazili metinleri al ve yazdır


    @Test
    public void jsExecuterGetValueTest() {
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();

        //3)Tarih kısmındaki Yazili metinleri al ve yazdır

        JavascriptExecutor js= (JavascriptExecutor) driver;
        String checkinDate=js.executeScript("return document.getElementById('checkin_date').value").toString();
        System.out.println("checkinDate : "+checkinDate);



    }
}