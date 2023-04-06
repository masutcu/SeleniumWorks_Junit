package day03Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C01_DropDownMenu extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Books" secenegini secin
    // arama cubuguna "Java" aratın
    // arama sonuclarinin Java icerdigini test edin

    @Test
    public void test01(){

        driver.get("https://amazon.com");
        //DropDown 3 adımda handle edilir
        //1-)DropDown Locate Edilmelidir
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2-)Select Objesi Olusturulur
        Select select=new Select(ddm);
        //3-)Opsiyonlardan Bir Tanesi Secilir
        select.selectByVisibleText("Books");
       driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
       String sonuc=driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
       Assert.assertTrue(sonuc.contains("Java"));

    }


}
