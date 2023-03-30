package day06NT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev2 {
    public static void main(String[] args) throws InterruptedException {
       // “https://www.saucedemo.com” Adresine gidin
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // Username kutusuna “standard_user” yazdirin
        driver.get("https://www.saucedemo.com");
        driver.findElement(By.cssSelector("input[id='user-name'")).sendKeys("standard_user");
       // Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.cssSelector("input[id='password'")).sendKeys("secret_sauce");
       // Login tusuna basin
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("input[id='login-button'")).submit();
        //    Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String urunAdi = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        System.out.println(urunAdi);

        //    Add to Cart butonuna basin
       driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        //    Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        //    Sectiginiz urunun basarili olarak sepete eklendigini kontrol edin
       WebElement element = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
       if(element.isDisplayed()){
           System.out.println("Test PASSED");
       }else{
           System.out.println("Test FAILED");
       }
       //    Sayfayi kapatin
       driver.close();

    }
}
