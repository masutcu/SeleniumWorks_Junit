package day07NT_Junit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C05_BeforeAfterClassTest {
    WebDriver driver;
    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Amazon Testi Başlatıldı");
    }
    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Amazon Testi Sonuçlandı");
    }
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
    public void test01() {
        driver.get("https://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);

    }
    @Test
    public void test02() {
        System.out.println("ikinci test");
    }
}

