package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev3 {
    /*
    .Bir Class olusturalim YanlisEmailTesti
2.http://automationexercise.com sayfasina gidelim
3.Sign in butonuna basalim
4.Email kutusuna @isareti olmayan bir mail yazip enter’a
bastigimizda “Invalid email address” uyarisi ciktigini test edelim
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationexercise.com");
    }

    @AfterClass
    public static void teardown() throws Exception {
        Thread.sleep(2000);
        //driver.close();
    }
    @Test //Sign in butonuna basalim, .Email kutusuna @isareti olmayan bir mail yazip
    // enter’a bastigimizda giriş yapılamadığını test edelim
    public void singUp(){
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        WebElement email=driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("kajfkaf.com"+Keys.ENTER);

        WebElement passButton= driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        boolean passwordB=passButton.isSelected();
        Assert.assertFalse(passwordB);

    }
}
