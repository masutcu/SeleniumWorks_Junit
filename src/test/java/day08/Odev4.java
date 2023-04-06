package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev4 {
    /*
    -BeforeClass methodu ile driver ı olusturun ve Maximize edin, 15 sn bekletin
-Before methodunda http://www.google.com adresine gidin
-Üç farklı test methodu ile;
-arama kutusuna "The God Father" yazip, cikan sonuc sayisini yazdirin
-arama kutusuna  "Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
-arama kutusuna  "Kill Bill" yazip, cikan sonuc sayisini yazdirin
-NOT: Çıkan sonuç sayılarını After methodunda yazdırınız
-AfterClass ile kapatın
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @AfterClass
    public static void teardown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }
    @Before
    public  void start(){
        driver.get("http://google.com");

    }
    @After
    public void sonuclar(){
        WebElement sonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        String netice=sonuc.getText().split(" ")[1];
        int sonuc1=Integer.parseInt(netice.replaceAll("\\D",""));
        System.out.println(sonuc1+ " adet sonuç var");
    }
    @Test
    public void godF(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).
                sendKeys("The God Father"+ Keys.ENTER);

    }
    @Test
    public void lordK(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).
                sendKeys("Lord of the Rings"+ Keys.ENTER);
            }
    @Test
    public void killB(){
        driver.findElement(By.xpath("//input[@class='gLFyf']")).
                sendKeys("Kill Bill"+ Keys.ENTER);

    }
}
