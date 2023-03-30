package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev {
    // -https://www.facebook.com adresine gidin
    // -Cookies’i kabul edin
    // -“Create an Account” button’una basin
    // -“radio buttons” elementlerini locate edin
    // -Secili degilse cinsiyet butonundan size uygun olani secin
    WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown() throws Exception {
        Thread.sleep(2000);
        //driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
        Thread.sleep(2000);

        WebElement radio=driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
        boolean seciliMİ=radio.isSelected();
        Assert.assertFalse(seciliMİ);
        radio.click();

    }


}