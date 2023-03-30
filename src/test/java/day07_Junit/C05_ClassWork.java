package day07_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05_ClassWork {


    WebDriver driver;
    @Before
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @After
    public  void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //a.Verilen web sayfasına gidin.

        //https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b.Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkbox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        Thread.sleep(2000);
        WebElement checkbox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        //c.Checkbox1 seçili değilse onay kutusunu tıklayın
        System.out.println(checkbox1.isSelected());
        System.out.println(checkbox2.isSelected());
        //d.Checkbox2 seçili değilse onay kutusunu tıklayın
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        if(!checkbox2.isSelected()){
            checkbox1.click();
        }
    }

}
