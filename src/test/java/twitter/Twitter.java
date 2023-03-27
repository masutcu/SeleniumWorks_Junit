package twitter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Twitter {
    public static void main(String[] args) throws InterruptedException {


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://twitter.com");
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//div[@aria-label='Kapat']")).click();
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        Thread.sleep(2000);
        WebElement telIleGiris = driver.findElement(By.xpath("//input[@autocomplete='username']"));
        telIleGiris.click();
        telIleGiris.sendKeys("5531610100");
        driver.findElement(By.xpath("//span[text()='İleri']")).click();
        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Litvanya4253");
        Thread.sleep(2000);
        //password.submit();
        driver.findElement(By.cssSelector("div[data-testid='LoginForm_Login_Button'")).click();
        Thread.sleep(2000);

        int counter = 0;
        do {
            driver.findElement(By.xpath("//div[@class='DraftEditor-editorContainer']")).click();
            Thread.sleep(1000);
            WebElement textBox = driver.findElement(By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div[1]/div/div[3]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div[2]/div/div/div/div/label/div[1]/div/div/div/div/div/div[2]/div/div/div/div"));
            textBox.sendKeys("#EGMveTSKborclanmaMagdurları SGK dan müjdeli haber bekliyor.");
            driver.findElement(By.xpath("//div[@data-testid='tweetButtonInline']")).click();
            counter++;


        } while (counter != 5);

    }
}
