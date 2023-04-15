package day16_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C05_StaleElementException extends TestBase {
     /*
        StaleElementReferanceException:
               Bir web sayfasındaki bir webelementin geçerliliğinin kaybolduğu durumlarda oluşur.
            Yani bir webelementi locate ettikten sonra sayfada refresh yada back-forward kullanıyorsak
            yeniden o elemente ulaşmak istediğimizde bu hatayı alırız. Bunu handle edebilmek için
            webelemente yeniden aynı locate'i atamalıyız.(Webelementin locate'ini hatırlatma gibi diyebiliriz)
     */

    @Test
    public void StaleElementReferanceExceptionTest1() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().refresh();

        //login butonuna tıklayalım
        driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]")).click();

    }

    @Test
    public void StaleElementReferanceExceptionTest2() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        //Sayfaya gittikten sonra sayfayı yenileyelim

        //login'e tıklayınız
        login.click();//org.openqa.selenium.StaleElementReferenceException
        //Webelementi locate ettikten sonra sayfayı yeniledik ve sonrasında click yaptık ve StaleElementReferenceException
        // hatasını aldık çünkü locate ettiktan sonra refresh yaptığımız için element eskimiş oldu. Dolayısıyla bu
        // exception'ı handle edebilmek için click yapmadan önce tekrar aynı locati webelemente atamamız gerekir
    }

    @Test
    public void StaleElementReferanceExceptionTest3() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));

        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().refresh();

        //login'e tıklayınız
        login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();

    }

    @Test
    public void StaleElementReferanceExceptionTest4() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);
        driver.findElement(By.xpath("//*[@class='eicon-close']")).click();//Reklam kapatmak için

        //login butonuna tıklayalım
        WebElement login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]"));
        login.click();
        bekle(2);
        //Sayfaya gittikten sonra sayfayı yenileyelim
        driver.navigate().back();

        //login'e tıklayınız
        //login = driver.findElement(By.xpath("(//*[text()='LMS LOGIN'])[1]")); bu atamayı tekrar yaparsak exception almayız
        Assert.assertTrue(login.isDisplayed());//org.openqa.selenium.StaleElementReferenceException:
        //Webelemente yeni locate'ini atamadığımız için bu hatayı aldık
    }

    @Test
    public void StaleElementReferanceExceptionTest5() {
        //NOT:StaleElementReferanceException hatası almamız gerekiyor
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back();
            bekle(3);
            if (i==4){
                break;
            }
        }
        //Sayfayı kapatalım
    }

    @Test
    public void StaleElementReferanceExceptionTest6() {
        //Amazon sayfasına gidelim
        driver.get("https://amazon.com");
        //iphone aratalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        //Çıkan sonuclardan ilk 5'ine tıklayıp sayfa başlıklarını alalım konsola yazdıralım
        List<WebElement> urunler = driver.findElements(By.xpath("//h2"));
        for (int i = 0; i < urunler.size(); i++) {
            urunler.get(i).click();
            bekle(3);
            driver.navigate().back();
            bekle(3);
            if (i == 4) {
                break;
            }
            urunler = driver.findElements(By.xpath("//h2")); //bayatlayan elementi tekrar hatırlattık
        }
    }
}
