package day06NT_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Odev1 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://www.google.com/ adresine gidin  3- cookies uyarisini kabul ederek kapatin
        driver.get("https://google.com");
        //Sayfa basliginin “Google” ifadesi icerdigini test edin
        String baslık=driver.getTitle();
        System.out.println("baslık = " + baslık);
        if(baslık.contains("Google")){
            System.out.println("baslık google içeriyor");
        }else System.out.println("başlıkta google geçmiyor");
        //Arama cubuguna “Nutella” yazip aratin
        WebElement arama=driver.findElement(By.xpath("//input[@class='gLFyf']"));
        arama.sendKeys("Nutella"+ Keys.ENTER);
        //Bulunan sonuc sayisini yazdirin
        WebElement sonuc=driver.findElement(By.xpath("//div[@id='result-stats']"));
        String sonucSayisi=sonuc.getText();
        System.out.println("sonuc sayisi = " + sonuc.getText());

        //sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String sonucSayi=sonucSayisi.split(" ")[1];
        System.out.println(sonucSayi);
        String sonucsayi1=sonucSayi.replaceAll("[^0-9]","");
        System.out.println(sonucsayi1);
        int num=Integer.parseInt(sonucsayi1);
        System.out.println(num);


        if(num>10000000){
            System.out.println("sonuç 10 milyondan büyük");
        }else System.out.println("sonuç 10 milyondan küçük");
        //Sayfayi kapatin

        driver.close();

    }
}
