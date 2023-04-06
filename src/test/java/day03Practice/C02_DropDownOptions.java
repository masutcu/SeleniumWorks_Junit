package day03Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;

public class C02_DropDownOptions extends TestBase {
    // https://www.amazon.com/ sayfasina gidin
    // dropdown'dan "Baby" secenegini secin
    // sectiginiz option'i yazdirin
    // dropdown'daki optionlarin toplam sayısının 28'e esit oldugunu test edin
    // dropdown'daki optionların tamamını yazdırın


    @Test
    public void test(){
        driver.get("https://amazon.com");
        WebElement ddm= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("Baby");

        String selectedOps=select.getFirstSelectedOption().getText();
        System.out.println("selectedOps = " + selectedOps);

        List<WebElement> opsiyonlar=select.getOptions();
        int expectedOpSayisi=28;
        int actualsayi=  opsiyonlar.size();
        Assert.assertEquals(expectedOpSayisi,actualsayi);

        opsiyonlar.stream().forEach(t-> System.out.println(t.getText()));
    }
}
