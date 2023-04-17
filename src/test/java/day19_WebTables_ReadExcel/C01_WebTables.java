package day19_WebTables_ReadExcel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    //    https://the-internet.herokuapp.com/tables sayfasına gidin
//    Task 1 : Table1’i yazdırın
//    Task 2 : 3. Satır verilerini yazdırın
//    Task 3 : Son verilerini verileri yazdırın
//    Task 4 : 5. Sütun verilerini yazdırın
//    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
//    Parameter 1 = satır numarası
//    Parameter 2 = sütun numarası
//    printData(2,3);  => 2. satır, 3. sütundaki veriyi yazdırsın.



    //    Task 1 : Table1’i yazdırın
    @Test
    public void table1Print() {
        //    https://the-internet.herokuapp.com/tables sayfasına gidin
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1=driver.findElement(By.id("table1")).getText();
        System.out.println("table1 = " + table1);

        //elementleri tektek yazdıralım
        List<WebElement> tumElementler=driver.findElements(By.xpath("//table[@id='table1']//td"));
        tumElementler.stream().forEach(t-> System.out.println(t.getText()));

    }

    //    Task 2 : 3. Satır verilerini yazdırın

    @Test
    public void thirdRDataPrint() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> satır3List=driver.findElements(By.xpath("//table[@id='table1']//tr[3]//td"));
        satır3List.forEach(t-> System.out.println(t.getText()));

    }

    //    Task 3 : Son satırın verilerini verileri yazdırın

    @Test
    public void sonSatir() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatirList=driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[last()]"));
        sonSatirList.forEach(t-> System.out.print(t.getText()+" | "));
    }

    //    Task 4 : 5. Sütun verilerini yazdırın

    @Test
    public void sutun5() {
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> tum5List=driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        tum5List.forEach(t-> System.out.print(t.getText()+" | "));
    }
    //    Task 5 : Iki parametreli bir Java metodu oluşturalım: printData
    //    Parameter 1 = satır numarası 2 olsun
    //    Parameter 2 = sütun numarası 3 olsun

    public void printDataSelected(int satir,int sutun) {
        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement istenilen=driver.findElement(By.xpath("//table[@id='table1']//tr["+satir+"]/td["+sutun+"]"));
        System.out.println("istenilen " + istenilen.getText());
    }

    @Test
    public void printDataTest() {
        printDataSelected(2,3);
        printDataSelected(3,5);
    }

}
