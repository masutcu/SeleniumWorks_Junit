package day07NT_Junit;

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
import java.util.List;

public class Odev2 {
   WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public  void teardown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
   //*** Aşağıdaki Task'i Junit framework'u ile yapınız
    @Test
    public void test01() throws InterruptedException {
        //- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        //            - Add Element butonuna 100 defa basınız
        for(int i=0; i<100; i++) {
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
            //- 100 defa basıldığını test ediniz
            //- 90 defa delete butonuna basınız
            //- 90 defa basıldığını doğrulayınız
        }
        List<WebElement> deleteButton=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        if(deleteButton.size()==100){
            System.out.println("100 adet delete button var. Test Passed");
        }else System.out.println("test failed");
        for(int i=0; i<90; i++) {
            driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
        }
        List<WebElement> deleteButton1=driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        if(deleteButton1.size()==10){
            System.out.println("10 adet delete button kaldı. Test Passed");
        }else System.out.println("test failed");
        Thread.sleep(3000);

    }


}
