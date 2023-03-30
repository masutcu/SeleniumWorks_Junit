package day07NT_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Odev1 {
    //  *** Aşağıdaki Task'i Junit framework'u ile yapınız
    //
    ////- sayfayı kapatalım
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

    @Test
    public void test01() throws InterruptedException {
        //- ebay sayfasına gidiniz
        driver.get("https://ebay.com");
        //- electronics bölümüne tıklayınız
        driver.findElement(By.xpath("(//a[@_sp='p2481888.m1379.l3250'])[1]")).click();
        // - Genişliği 225 ve Uzunluğu 225 olan resimlerin hepsine tıklayalım
        // - Her sayfanın sayfa başlığını yazdıralım



        for(int i=0; i<24;i++){
            List<WebElement> pictures=driver.findElements(By.xpath("//img[@width='225' and @height='225']"));
            System.out.println("pictures.size() = " + pictures.size());
            pictures.get(i).click();
            String isim=driver.getTitle();
            System.out.println(isim);
            Thread.sleep(2000);
            driver.navigate().back();
        }


    }
}