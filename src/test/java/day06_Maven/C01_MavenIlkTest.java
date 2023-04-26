package day06_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //1https://www.amazon.com/ sayfasına gidelim
        driver.get("https://www.amazon.com");
        //2Arama kutusunu locate edelim
        WebElement aramaKutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        //3“Samsung headphones” ile arama yapalım
        aramaKutusu.sendKeys("Samsung headphones"+ Keys.ENTER);
        //4Bulunan sonuç yazısını yazdıralım
        WebElement aramaSonuc=driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[1]"));
        String sonuc=aramaSonuc.getText();
        System.out.println(sonuc);
        //5İlk ürünü tıklayalım
        //Tüm arama sonucu ürünleri list içini koyup ilk elemanı tıklıyoruz
        List<WebElement> urunlistesi = driver.findElements(By.xpath("//img[@class='s-image']"));
        urunlistesi.get(0).click();
        //6Sayfadaki tüm başlıkları yazdıralım
        List<WebElement> basliklar=driver.findElements(By.xpath("//h1")); //4 h1 var
        for(WebElement w:basliklar){
            System.out.println(w.getText());
        }
        //veya Laambda ile
        basliklar.stream().forEach(t-> System.out.println(t.getText()));

        driver.close();


    }
}
