package day15_FileUpload_Waits;

import dev.failsafe.internal.util.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C01_FileUpload extends TestBase {
    /*
https://the-internet.herokuapp.com/upload adresine gidin
logo.jpeg dosyasını yükleyin(uopload)
"File Uploaded!" textinin görüntülendiğini test edin
*/

    @Test
    public void fileUploadTest() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
        bekle(2);

        //chooseFileButton.sendKeys("C:/Users/Lenovo/Desktop/logo.jpeg.jpg");//dinamik değil
        chooseFileButton.sendKeys(System.getProperty("user.home")+"/Desktop/logo.jpeg.jpg");//dinamik
        WebElement fileUploadButton=driver.findElement(By.id("file-submit"));
        fileUploadButton.click();

        WebElement text=driver.findElement(By.xpath("//h3"));
        assertTrue(text.isDisplayed());


    }
}
