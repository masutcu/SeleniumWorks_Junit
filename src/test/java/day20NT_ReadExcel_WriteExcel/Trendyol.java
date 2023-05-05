package day20NT_ReadExcel_WriteExcel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Trendyol extends TestBase {
    @Test
    public void trendyol() {
        //trendyol ddm seçim kısmı x path alımı



        //il sec
        WebElement dropdownElement = driver.findElement(By.name("cityId"));
        dropdownElement.click();
        WebElement optionElement = driver.findElement(By.xpath("//div[@class='ty-select-option' and text()='Adıyaman']"));
        optionElement.click();
        //ilce sec
        WebElement ilceElement = driver.findElement(By.name("districtId"));
        ilceElement.click();
        WebElement optionIlce = driver.findElement(By.xpath("//div[@class='ty-select-option' and text()='Besni']"));
        optionIlce.click();
        //mahalle sec
        WebElement mahelleElement = driver.findElement(By.name("neighborhoodId"));
        mahelleElement.click();
        WebElement optionMahalle = driver.findElement(By.xpath("//div[@class='ty-select-option' and text()='Abımıstık Mah (Çakırhüyük Köyü)']"));
        optionMahalle.click();
        //adres gir

    }
}