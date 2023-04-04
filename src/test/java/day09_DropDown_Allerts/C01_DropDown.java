package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_DropDown {
    /*
    DropDownMenü - DDM - : Alt başlıkların olduğu açılır menü ye denir.
    Nasıl handle edilir;
    a) ilk olarak locate alınır.
    b) select objesi oluştururuz.
    c) select objesinin Dropdown menü elementinin içeriğine ve seçeneklerine erişim
    sağlaması için select sınıfına argument olarak locate ettiğimiz WepElement i koyarız.
    Syntax : Select select=new Select(ddm WE)
    d-Select class'i sadece <select> tag'i ile olusturulmus DropDown menulere uygulanabilir.
    e-Select objesi ile 3 method kullanılır.
        1-selectByVisiableText() --> Elementin görünen taxt i ile ulaşmamızı sağlar
        2-selectByValue() --> attiribute değeri ile ulaşmamızı sağlar
        3-selectByIndex() --> elementin değeri ile ulaşılır. index 0 dan başlar
    f-getOptions() --> Lacate edilen DDM deki tüm secenekleri döndürür
    g-getFirstSelectedOption() --> DDM deki seçili olan ilk seçeneği döndürür
     */
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @After
    public void tearDown() throws Exception {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test1() {
        //tüm eyaletleri yazdıralım
        List<WebElement> tumEyaletler = driver.findElements(By.xpath("//*[@id='state']//option"));
        System.out.println(tumEyaletler.get(2).getText());
        tumEyaletler.forEach(t -> System.out.println(t.getText()));
        //sayfadaki tüm ddm lerdeki tüm seçenekleri yazdıralım
        List<WebElement> tumOptionlar = driver.findElements(By.tagName("option"));
        tumOptionlar.forEach(t -> System.out.println(t.getText()));

    }
}