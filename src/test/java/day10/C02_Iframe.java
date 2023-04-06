package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_Iframe extends TestBase {

        @Test
        public void iframe() {
            //➢	https://testcenter.techproeducation.com/index.php?page=iframe
            driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

            //➢	Ana sayfadaki ‘An iframe with a thin black border:’ metninde ‘black border’ yazisinin   oldugunu test edelim
            String actualText1 = driver.findElement(By.xpath("//p[text()='An iframe with a thin black border:']")).getText();
            Assert.assertTrue(actualText1.contains("black border"));

            //➢	Ayrica ‘Applications lists’ yazisinin sayfada oldugunu test edelim
            driver.switchTo().frame(0); //--> iframe varsa ve geçiş yapmazsak NoSuchElementException hatası alırız
        /*
        Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydim index'i 1 almam gerekicekti
        Örneğin:
            <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe");
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> -->Eğer bir üst frame içinde bir frame daha varsa tekrar driver.switchTo().frame("innerIframe");
	            </iframe>
            </body>
        -Index ile yukarıda bahsettiğimiz gibide yapabilirsiniz
        -iframe'i locate ederekte örneğin yukarıdaki kodun "iframe[id='outerIframe']" ccsSelector ile locate edilmiş hali
        -id ve name attributu varsa "driver.switchTo().frame("outerIframe")" bu şekildede geçiş yapabilirsiniz
         */
            String actualText2 = driver.findElement(By.xpath("//*[text()='Applications lists']")).getText();
            Assert.assertEquals(actualText2,"Applications lists");

            //➢	Son olarak footer daki ‘Povered By’ yazisini varligini test edilip
            driver.switchTo().defaultContent();
            WebElement poveredByYazisi = driver.findElement(By.xpath("//*[text()='Povered By']"));
            Assert.assertTrue(poveredByYazisi.getText().contains("Povered By"));
        }

    }


