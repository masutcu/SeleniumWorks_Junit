package day06NT;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_MavenClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
       //Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
       //Login alanine  “username” yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
       //Password alanine “password” yazdirin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        Thread.sleep(2000);
       //Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//input[@name='submit']")).submit();
        driver.navigate().back();//güvenlik nedeni ile sayfa açmadı, navigate back ile geçtik
       //Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//li[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
       //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("999");
        Thread.sleep(1000);
       //tarih kismina “2020-09-10” yazdirin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        Thread.sleep(1000);

       //Pay buttonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
       //“The payment was successfully submitted.” mesajinin ciktigini control edin
        String message=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']")).getText();

        if(message.equals("The payment was successfully submitted.")){
        System.out.println("passed");
        }else {
        System.out.println("failed");
}
        //veya
        WebElement mesaj=driver.findElement(By.xpath("//span[text()='The payment was successfully submitted.']"));
        if(mesaj.isDisplayed()){
            System.out.println("passed");
        }else {
            System.out.println("failed");
    }

}
}
