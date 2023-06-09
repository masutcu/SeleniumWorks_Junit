package day06NT_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class C01Maven_IlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       //https://www.amazon.com/ sayfasina gidelim

        driver.get("https://amazon.com");
        //arama kutusunu locate edelim
        WebElement aramakutusu=driver.findElement(By.id("twotabsearchtextbox"));
        //“Samsung headphones” ile arama yapalim
        aramakutusu.sendKeys("Samsung headphones");
        aramakutusu.submit();
        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi=driver.findElement(By.xpath("(//*[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String[] sonuc=sonucSayisi.getText().split(" ");
        System.out.println("Bulunan sonuc sayisi : "+sonuc[2]);
        Arrays.stream(sonuc).skip(2).limit(1).forEach(System.out::println);
        //Ilk urunu tiklayalim
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();

        //Sayfadaki tum basliklari yazdiralim
        List<WebElement> sayfaBasliklari=driver.findElements(By.xpath("//h1"));
        for(WebElement w:sayfaBasliklari){
            System.out.println(w.getText());
        }
        sayfaBasliklari.forEach(t-> System.out.println(t.getText()));

        //sayfayı kapatın
        driver.close();
    }
}
