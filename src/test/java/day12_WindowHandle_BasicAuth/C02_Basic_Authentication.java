package day12_WindowHandle_BasicAuth;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class C02_Basic_Authentication extends TestBase {
     /*

    Aşağıdaki bilgileri kullanarak authentication yapınız:

    Url: https://the-internet.herokuapp.com/basic_auth
    Username: admin
    Password: admin

    Başarılı girişi doğrulayın.
     */

    //Authentication Url: "https://admin:admin@the-internet.herokuapp.com/basic_auth"

    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/basic_auth adresine gidiniz
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        //Paragrafın "Congratulations" kelimesini içerdiğini doğrulayınız
        String paragraf = driver.findElement(By.xpath("//p")).getText();
        assertTrue(paragraf.contains("Congratulations"));

    }
}
