package day21_JavaScriptExecuter;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSExecuter_Type extends TestBase {

    //techpro sayfasına gidelim ve arama kutusuna qa yazalım

    @Test
    public void jsExecuter_TypeTest() {
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();//reklamı kapattık
        WebElement searchBox=driver.findElement(By.xpath("//input[@type='search']"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value'),'QA')", searchBox);

        //oluşturduğumuz method ile de yapalım
        typeWithJSc("helllo world",searchBox);
    }
}
