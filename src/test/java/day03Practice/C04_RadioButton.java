package day03Practice;

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

public class C04_RadioButton {
    // https://demo.guru99.com/test/radio.html adresine gidin
    // radiobutton elementlerini locate edin
    // option2'yi secin
    // option2 elementlerinin secili oldugunu Test edin
    // option1 elementlerinin secili olmadıgını test edin
    // option3 elementlerinin secili olmadıgını test edin
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
    public void radioButton() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/radio.html");
        WebElement opsiyon1=driver.findElement(By.xpath("//input[@id='vfb-7-1']"));
        WebElement opsiyon2=driver.findElement(By.xpath("//input[@id='vfb-7-2']"));
        WebElement opsiyon3=driver.findElement(By.xpath("//input[@id='vfb-7-3']"));
        Thread.sleep(1000);

        opsiyon2.click();

        Assert.assertTrue(opsiyon2.isSelected());

        Assert.assertFalse(opsiyon1.isSelected() && opsiyon3.isSelected());
        Thread.sleep(1000);


    }

}
