package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class C01_Assertion {
    /*
            2)https://amazon.com adresinegidin
            3)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
            ○ title Test  => Sayfa başlığının “Amazon” oldugunu test edin
            ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
            ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
            ○ wrongTitleTest => Sayfa basliginin “amazon”içermediğini dogrulayin
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
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
        String actualTitle=driver.getTitle();
        String expectedTitle="Amazon";
        boolean iceriyorMu=actualTitle.contains(expectedTitle);
        assertTrue(iceriyorMu);
    }

    @Test
    public void test02() {
        WebElement logo=driver.findElement(By.id("nav-logo-sprites"));
        boolean gorunurMu=logo.isDisplayed();
        assertTrue(gorunurMu);
    }

    @Test
    public void test03() {
        WebElement searchBox=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        assertTrue(searchBox.isEnabled());
    }

    @Test
    public void test04() {
        String actualTitle=driver.getTitle();
        String expectedTitle="amazon"; //küçük harf
        assertFalse(actualTitle.contains(expectedTitle));
    }
}
