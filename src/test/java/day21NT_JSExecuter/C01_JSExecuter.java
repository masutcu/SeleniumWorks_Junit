package day21NT_JSExecuter;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecuter extends TestBase {
    // Eğer bir html sayfasının tamamı veya bir kısmı javscript ile oluşturuldu ise o sayfaya müdahale etmek için genellikle
    // java script executer ara yüzü kullanılması gerekir. bu durumda sayfayı manipüle etmek veya etkileşimde bulunmak için
    // standart wepdriver komutları yetersiz kalabilir
    // bu nedenle java script executer arayüzü sayfanın JS kodlarına doğrudan erişebilir.Ancak mümkünse
    // web driver in sunduğu standart yöntemlerle sorunları çözmek herzaman daha iyidir.
    // Çünkü JS kullanımı sayfanın daha yavaş yüklenmesine neden olabilir..

    @Test
    public void clickByJavaSTest() {
        /*
    http://www.uitestpractice.com/Students/Form sayfasına git
    Formu doldur
    Submit tuşuna tıkla
    Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
    */

            //http://www.uitestpractice.com/Students/Form sayfasına git
            driver.get("http://www.uitestpractice.com/Students/Form ");
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        //Formu doldur
            Faker faker = new Faker();
            WebElement firstName = driver.findElement(By.id("firstname"));
            firstName.sendKeys(faker.name().firstName(), Keys.TAB,faker.name().lastName(),Keys.TAB,Keys.TAB,Keys.TAB,
                    Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,faker.phoneNumber().cellPhone());
            //Submit tuşuna tıkla
        WebElement submit = driver.findElement(By.xpath("//*[text()='Submit']"));
        try {
            submit.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",submit);
        }
            //Sayfa adresinin "http://www.uitestpractice.com/Students/Form?optradio=on" olduğunu doğrula.
        Assert.assertEquals("http://www.uitestpractice.com/Students/Form",driver.getCurrentUrl());
        }

    }

