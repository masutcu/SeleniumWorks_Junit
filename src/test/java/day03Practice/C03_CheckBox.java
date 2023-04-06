package day03Practice;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.TestBase;

import java.time.Duration;

public class C03_CheckBox {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // checkbox elementlerini locate edin
    // checkbox1 ve checkbox3  secili degil ise secin
    // checkbox1 ve checkbox3 elementlerinin secili oldugunu Test edin
    // checkbox2 elementinin secili olmadıgını test edin
    WebDriver driver;

    @Before
    public void setUp() throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }


    @Test
    public void checkBox() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement checkbox1=driver.findElement(By.xpath("//input[@id='vfb-6-0']"));
        WebElement checkbox2=driver.findElement(By.xpath("//input[@id='vfb-6-1']"));
        WebElement checkbox3=driver.findElement(By.xpath("//input[@id='vfb-6-2']"));
        Thread.sleep(1000);

        if(!checkbox1.isSelected()){
            checkbox1.click();
            Thread.sleep(1000);

        }
        if(!checkbox3.isSelected()){
            checkbox3.click();
            Thread.sleep(1000);

        }
        Assert.assertTrue(checkbox1.isSelected() && checkbox3.isSelected());


        Assert.assertFalse(checkbox2.isSelected());
        Thread.sleep(1000);



    }
}
