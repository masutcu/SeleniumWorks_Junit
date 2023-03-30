package day07NT_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Lcw {

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    //@After
    //public  void teardown() throws Exception {
    //    Thread.sleep(2000);
    //    driver.close();
    //}
    //*** Aşağıdaki Task'i Junit framework'u ile yapınız
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://lcwaikiki.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("button[class='search-form__input-field__btn-search false']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//a[@class='item-anchor'])[2]")).click();

    }
}
