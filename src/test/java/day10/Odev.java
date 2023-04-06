package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Odev extends TestBase {
    /*
    //● https://the-internet.herokuapp.com/iframe adresine
//gidin.
//● Bir metod olusturun: iframeTest
//○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
//○Text Box’a “Merhaba Dunya!” yazin.
//○TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur
//oldugunu dogrulayin ve konsolda yazdirin
     */

    @Test
    public void test(){
        // https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
// Bir metod olusturun: iframeTest
// “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement txt=driver.findElement(By.xpath("//h3[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(txt.isDisplayed());
//Text Box’a “Merhaba Dunya!” yazin.
        //driver.switchTo().frame("mce_0_ifr");
        driver.switchTo().frame(0);
        WebElement text=driver.findElement(By.xpath("//body[@id='tinymce']"));
        text.click();
        text.clear();
        text.sendKeys("Merhaba Dunya!"+ Keys.ENTER);

//TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();
       WebElement dogrula= driver.findElement(By.xpath("(//a[@target='_blank'])[2]"));
       Assert.assertTrue(dogrula.isDisplayed());
        System.out.println(dogrula.isDisplayed());
    }
}
