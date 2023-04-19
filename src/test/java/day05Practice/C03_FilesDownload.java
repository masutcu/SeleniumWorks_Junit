package day05Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesDownload extends TestBase {
    // 'https://the-internet.herokuapp.com/download' adresine gidiniz
    // some-file.txt dosyasini indirelim
    // dosyanin bilgisayarınızda Downloads(indirilenler)'a basariyla indirilip indirilmedigini test ediniz


    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/download");
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();
        bekle(2);
        // C:\Users\Lenovo   \Downloads\some-file.txt
        String lokalSabit="\\Downloads\\some-file.txt";
        String lokalDegisken=System.getProperty("user.home");
        String dosyaYolu=lokalDegisken+lokalSabit;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
