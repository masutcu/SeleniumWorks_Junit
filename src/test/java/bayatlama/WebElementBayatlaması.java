package bayatlama;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
public class WebElementBayatlaması extends TestBase{


        @Test
        public void staleElementExceptionTest(){

            driver.get("https://www.techproeducation.com");
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            driver.navigate().refresh();

            WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
            lmsLogin.click();//Çalıştı

        }

        @Test
        public void staleElementExceptionTest2(){

            driver.get("https://www.techproeducation.com");
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
            driver.navigate().refresh();
            lmsLogin.click();//org.openqa.selenium.StaleElementReferenceException
            //Locator doğru fakat adres refresh sonrası silindiği için "lmsLogin" container'ı artık kullanılamaz. Yeniden locate gerekir.
        }

        @Test
        public void staleElementExceptionTest3(){

            driver.get("https://www.techproeducation.com");
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
            lmsLogin.click();

            driver.navigate().back();//techproeducation.com sayfasına geri döndüm
            lmsLogin.click(); //org.openqa.selenium.StaleElementReferenceException çünkü lmslogin referansı kayboldu
        }
        @Test
        public void staleElementExceptionTest4(){

            driver.get("https://www.techproeducation.com");
            driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

            WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
            lmsLogin.click();

            driver.navigate().back();//techproeducation.com sayfasına geri döndüm
            //tekrar locate yapılarak exception almanın önüne geçiliyor.
            lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
            lmsLogin.click(); //org.openqa.selenium.StaleElementReferenceException
        }
        @Test
        public void staleElementExceptionTest5(){

            driver.get("https://www.techproeducation.com");
            try { //reklemın çıkma ihtimali için try catch yaparak no such element exception handle edildi.
                driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
            }catch (Exception ignored){}
            WebElement lmsLogin = driver.findElement(By.linkText("LMS LOGIN"));
            lmsLogin.click();
            //ana sayfaya tekrar gidelim
            driver.get("https://www.techproeducation.com");
            //referans yine kayboldu

            lmsLogin.click();  //org.openqa.selenium.StaleElementReferenceException
        }
    }


