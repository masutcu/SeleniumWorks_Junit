package day21_JavaScriptExecuter;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter_Click extends TestBase {
    /*
http://www.uitestpractice.com/Students/Form sayfasına git
Formu doldur
Submit tuşuna tıkla
Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
*/

    @Test
    public void clickByJSTest() {
        driver.get("http://www.uitestpractice.com/Students/Form");
        driver.findElement(By.id("firstname")).sendKeys(Faker.instance().name().firstName());
        driver.findElement(By.id("lastname")).sendKeys(Faker.instance().name().lastName());
        driver.findElement(By.id("email")).sendKeys(Faker.instance().internet().emailAddress());

        //submit tıkla
        WebElement submit=driver.findElement(By.xpath("//button[text()='Submit']"));
        //submit.click(); ==>Selenium click() çalışmadı
        //Java Script Executer deneyelim
        //1. adım driver javascript Executer clasına cast edelim
        JavascriptExecutor jse=(JavascriptExecutor) driver;//Casting
        //executescript metodu ile uygun script i çalıştırıyoruz
        jse.executeScript("arguments[0].click();",submit);

        //clickByJavaSc(submit); //oluşturduğumuz method ile 


    }
}
