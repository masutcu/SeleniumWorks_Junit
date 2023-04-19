package day05Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.Set;

public class C01_ActionMoveToElement extends TestBase {
    // https://amazon.com adresine gidiniz
    // sag ust bolumde bulunan dil secenek menusunun acilmasi icin mause'u bu menunun ustune getirelim
    // Change country/region butonuna basiniz
    // United States dropdown'undan 'Turkey (Türkiye)' seciniz
    // Go to website butonuna tiklayiniz
    // acilan yeni sayfadanin Title'inin Elektronik icerdigini test ediniz


    @Test
    public void test01() {
        driver.get("https://amazon.com");
        Actions actions=new Actions(driver);
        String sayfa1Handle=driver.getWindowHandle();

        WebElement  dilMenu=driver.findElement(By.xpath("//a[@id='icp-nav-flyout']"));
        actions.moveToElement(dilMenu).perform();
        bekle(2);

        driver.findElement(By.xpath("(//div[@class='icp-mkt-change-lnk'])[1]")).click();

        //dropdown için 1:dropdown locate edilir, 2: select objesi oluşturulur. 3: seçilecek seçeneklocate edilir
        WebElement dropdown=driver.findElement(By.xpath("//select[@id='icp-dropdown']"));
        bekle(1);
        Select select=new Select(dropdown);
        select.selectByVisibleText("Turkey (Türkiye)");
        bekle(2);
        //dropdown toparlanması için farklı bir yere clik yapıyoruz.
        driver.findElement(By.xpath("//span[text()='Changing country/region website']")).click();
        bekle(1);

        driver.findElement(By.xpath("//input[@class='a-button-input']")).click();
        bekle(2);

        Set<String> wH=driver.getWindowHandles();
        System.out.println("sayfa 1 handle = "+sayfa1Handle);
        System.out.println("wH değerleri= " + wH);

        String sayfa2Handle="";
        for (String each: wH){
            if (!each.equals(sayfa1Handle)){
                sayfa2Handle=each;
            }
        }

        driver.switchTo().window(sayfa2Handle);

        String title=driver.getTitle();
        System.out.println("sayfa basligi = "+title);
        Assert.assertTrue(title.contains("Elektronik"));

    }
}
