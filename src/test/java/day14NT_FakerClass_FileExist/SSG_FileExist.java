package day14NT_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SSG_FileExist extends TestBase {
    @Test
    public void fileTest() {
        //  "C:\Users\Lenovo\Desktop\data.xlsx"
        String dosyaYolu="C:/Users/Lenovo/Desktop/data.xlsx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02() {
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));
        //burada user.home getProperty() metodu için key değerdir.
    }

    @Test
    public void test03() throws IOException {

        driver.get("https://bonigarcia.dev/selenium-webdriver-java/download.html");
        driver.findElement(By.xpath("//*[text()='WebDriverManager logo']")).click();
        bekle(5);
        String  dosya="C:/Users/Lenovo/Downloads/webdrivermanager.png";//yolu aldık
        Files.deleteIfExists(Paths.get(dosya));
        Assert.assertFalse(Files.exists(Paths.get(dosya)));

    }
}
