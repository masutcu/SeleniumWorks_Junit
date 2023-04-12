package day04Practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Iframe extends TestBase {
    // https://html.com/tags/iframe sayfasına gidiniz
    // Videoyu görecek kadar asagiya ininiz
    // Videoyu izlemek icin Play tusuna basiniz
    // Videoyu calistirdiginizi test ediniz
    // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz

    @Test
    public void test01() {
        driver.get("https://html.com/tags/iframe");
        // Videoyu görecek kadar asagiya ininiz
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        bekle(2);

        // Videoyu izlemek icin Play tusuna basiniz
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));

        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button ytp-large-play-button-red-bg']"));
        play.click();

        // Videoyu calistirdiginizi test ediniz

        WebElement youtubeText=driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));

        Assert.assertTrue(youtubeText.isDisplayed());
        bekle(2);

        // 'Powerful,but easy to misuse' yazısının gorunur oldugunu test ediniz
        driver.switchTo().defaultContent();
        //veya
        //driver.switchTo().parentFrame();
        WebElement textPower=driver.findElement(By.xpath("//span[@id='Powerful_but_easy_to_misuse']"));
        Assert.assertTrue(textPower.isDisplayed());

    }

}

