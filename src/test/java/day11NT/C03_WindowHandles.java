package day11NT;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandles extends TestBase {
    @Test
    public void windowHandles() {
        //https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //İlk sayfanın ID'sini(Window Handle değerini) alın.
        String ilkSayfaWindowHandle = driver.getWindowHandle();
        //Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement sayfaTexti = driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("Opening a new window",sayfaTexti.getText());
        //Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        Assert.assertEquals("The Internet",actualTitle);
        //"Click Here" butonuna tıklayın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        //Açılan pencereye geçin.
        /*
            Eğer bir button'a click yaptığımızda bizim kontrolümüz dışında yeni bir pencere açılıyorsa,
         o pencere içindeki webelementleri handle edebilmem için swichtto() methodu ile geçiş yapmam gerekir
         fakat kontrolümüz dışında açıldığı için handle değerini bilmediğimiz için tüm açılan pencereleri
         getWindowHandles() methodunu kullanarak bir SET'e assing ederiz. Yada ArrayList'e assing ederiz
         */
        Set<String> tumPenceler = driver.getWindowHandles();
        for (String w:tumPenceler) {
            if(!w.equals(ilkSayfaWindowHandle)){
                driver.switchTo().window(w);
            }
        }//Burda amaç bizim kontrolümüz dışında açılan pencerey geçiş yapmak
/*
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(1));
 */
        //Açılan yeni pencerenin sayfa başlığının(title) “New Window” olduğunu doğrulayın.
        String gercekBaslik = driver.getTitle();
        Assert.assertEquals("New Window",gercekBaslik);
        String ikinciSayfaHandleDegeri = driver.getWindowHandle();
        //Bir önceki pencereye dönüp sayfa başlığının “The Internet” olduğunu  doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandle);
        Assert.assertEquals("The Internet",driver.getTitle());
        bekle(3);
        //2. pencereye tekrar geçin.
        driver.switchTo().window(ikinciSayfaHandleDegeri);
        bekle(3);
        //1. pencereye tekrar dönün.
        driver.switchTo().window(ilkSayfaWindowHandle);
    }

}
