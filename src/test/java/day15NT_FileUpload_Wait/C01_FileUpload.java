package day15NT_FileUpload_Wait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_FileUpload extends TestBase {

    @Test
    public void fileUpload(){
        /*
    https://the-internet.herokuapp.com/upload adresine gidin
    logo.jpeg dosyasını yükleyin(upload)
    “File Uploaded!” textinin görüntülendiğini test edin
    */
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement dosyaSec=driver.findElement(By.id("file-upload"));
        bekle(2);
        //String dosyaYolu="C:/Users/Lenovo/Desktop/b129.txt";
        String dosyaYolu=System.getProperty("user.home")+"/Desktop/b129.txt";
        dosyaSec.sendKeys(dosyaYolu);
        driver.findElement(By.id("file-submit")).click();
        //"File Uploaded!" textinin görüntülendiğini test edin
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());
    }
}
