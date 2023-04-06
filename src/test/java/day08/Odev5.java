package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Odev5 {
    /*
    -Amazon sayfasına gidelim
    -Dropdown menuyu yazdıralım
    -Dropdown menuden sırasıyla ilk 5 başlığı (Arts&Crafts ile başlayıp Books'a kadar Books dahil) seçip
    başlık altındakileri aratalım. Her aramada sayfa başlığını yazdıralım
    Not: Select Class'ı kullanalım
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test01(){
        WebElement dropDown= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
        Select select=new Select(dropDown);
        List<WebElement> liste=select.getOptions();
        liste.forEach(t-> System.out.println(t.getText()));
        for(int i=1; i<6 ; i++){
         WebElement dropDown1= driver.findElement(By.xpath("//select[@aria-describedby='searchDropdownDescription']"));
         Select select1=new Select(dropDown1);
        select1.selectByIndex(i);
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        System.out.println(i+". sayfa başlığı = " + driver.getTitle());
        driver.navigate().back();
        }

    }

}