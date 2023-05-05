package day02Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01 {
    public static void main(String[] args) {
        // https://www.amazon.com/ adresine gidin
        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        // sayfayi kapatiniz

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));

        String actuelTagName = aramaKutusu.getTagName();

        String expectedTagName = "input";

        if(expectedTagName.equals(actuelTagName)){
            System.out.println("TagName input");
        }else{
            System.out.println("TagName input degil");
        }

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin

        String actuelNameDegeri = aramaKutusu.getAttribute("name");


        String expectedNameDegeri = "field-keywords";


        if(expectedNameDegeri.equals(actuelNameDegeri)){
            System.out.println("name attributenun degeri field keywords");
        }else{
            System.out.println("name attributenun degeri field keywords degil");
        }

        // sayfayi kapatiniz
        driver.close();







    }
}