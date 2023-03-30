package day08;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev2 {
    /*
1)https://www.youtube.com adresine gidin
2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin
=> Sayfa başlığının “YouTube” oldugunu test edin
=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
○Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://youtube.com");
    }

    @AfterClass
    public static void teardown() throws Exception {
        Thread.sleep(2000);
        driver.close();
    }

    @Test //Sayfa başlığının “YouTube” oldugunu test edin
    public void title() {
        String titleName=driver.getTitle();
        boolean titleTrue=titleName.contains("YouTube");
        Assert.assertTrue(titleTrue);
    }
    @Test //YouTube resminin görüntülendiğini (isDisplayed()) test edin
    public void picture() {
        WebElement picYoutube=driver.findElement(By.xpath("(//a[@id='logo'])[1]"));
        boolean isYouTubeDisplay=picYoutube.isDisplayed();
        Assert.assertTrue(isYouTubeDisplay);
    }
    @Test //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    public void searchButton() {
        WebElement searchBox=driver.findElement(By.xpath("//div[@id='search-input']"));
        boolean isSearchButtonAktive=searchBox.isEnabled();
        Assert.assertTrue(isSearchButtonAktive);
    }
    @Test //wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    public void titleNegative() {
        String title=driver.getTitle();
        boolean isExist=title.contains("youtube");
        Assert.assertFalse(isExist);
    }
}
