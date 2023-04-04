package day09;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C02_TaseBaseDemo extends TestBase {
    @Test
    public void test01(){
        //techpro sayfasına gidelim ve başlığın bootcamp içerdiğini test edelim
        driver.get("https://techproeducation.com");
        String actualTitle= driver.getTitle();
        String expectedTitle="Bootcamp";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

}
