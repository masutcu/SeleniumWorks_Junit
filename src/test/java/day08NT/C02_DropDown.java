package day08NT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
    //a. Yil,ay,gün dropdown menu'leri locate ediniz
    //b. Select objesi olustur
    //c. Select object i kullaarak 3 farkli sekilde secim yapiniz
    @Test
    public void test1() {
        WebElement yil=driver.findElement(By.xpath("//*[@id='year']"));
        Select year=new Select(yil);
        year.selectByIndex(22);
        //yil.sendKeys("2001"); //bazen buda kullanılabilir
        //driver.findElement(By.xpath("//*[@value='2016']")).click(); //eğer locate ediliyorsa buda olur
        WebElement ay=driver.findElement(By.xpath("//*[@id='month']"));
        Select month=new Select(ay);
        month.selectByVisibleText("April");
        //gün
        WebElement gun=driver.findElement(By.xpath("//*[@id='day']"));
        Select day=new Select(gun);
        day.selectByValue("27");

    }
    //a. Tüm eyalet isimlerini yazdıralım
    @Test
    public void test2() {
        WebElement tumEyaletler=driver.findElement(By.cssSelector("select[id='state']"));
        Select select=new Select(tumEyaletler);
        List<WebElement> stateList=select.getOptions();
        stateList.forEach(t->System.out.println(t.getText()));

    }
    //State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
    @Test
    public void tet3() {
        WebElement tumEyaletler=driver.findElement(By.cssSelector("select[id='state']"));
        Select select=new Select(tumEyaletler);
        String mevcutText=select.getFirstSelectedOption().getText();
        System.out.println(mevcutText);
        Assert.assertEquals("Select a State",mevcutText);
    }
}
