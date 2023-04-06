package day11NT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    /*
   https://the-internet.herokuapp.com/iframe sayfasına gidiniz
   Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
   Textbox içindeki yazıyı siliniz.
   Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
   Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
    */
    @Test
    public void iFrame(){
        driver.get("https://the-internet.herokuapp.com/iframe");
        WebElement baslik=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslik.getText().contains("Editor"));
        bekle(1);
        //texbox a geçiş
        driver.switchTo().frame(0);
        WebElement textbox=driver.findElement(By.id("tinymce"));
        bekle(1);
        textbox.clear();
        bekle(2);
        textbox.sendKeys("Bu textbox iFrame içinde yer almaktadır");
        //geri dönüş
        driver.switchTo().parentFrame();
        //ana sayfaya dönmek için switchTo defaultContent veya navigate refresh de kullanilabilir.
        WebElement text2=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(text2.isDisplayed());


    }
}
