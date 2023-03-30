package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_DropDown {
    //https://testcenter.techproeducation.com/index.php?page=dropdown
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @After
    public void tearDown() throws Exception {
        Thread.sleep(4000);
        driver.close();
    }
    @Test
    public void selectByIndex() throws InterruptedException {
        //1. Locate dropdown element
        WebElement yearDropDown=driver.findElement(By.xpath("//select[@id='year']"));
       //2.select objesi oluştur
        Select years= new Select(yearDropDown);
        //select objesini kullanarak 3 farklı şekilde seçim yapılabilir
        Thread.sleep(2000);
        years.selectByIndex(0);//seçenek 0 dan başlar. 2023 yi seçer

        //ay için Locate yapalım
        Thread.sleep(2000);
        WebElement monthDropDown=driver.findElement(By.xpath("//select[@id='month']"));
        Select months= new Select(monthDropDown);
        months.selectByVisibleText("June");//haziran ayının text i June

        //gün seçimi
        Thread.sleep(2000);
        WebElement dayDropDown=driver.findElement(By.xpath("//select[@id='day']"));
        Select days= new Select(dayDropDown);
        days.selectByValue("25");//25. gün


    }
    @Test
    public void printAll(){

        WebElement state=driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropDown= new Select(state);
        List<WebElement> stateList=stateDropDown.getOptions();

        for(WebElement w:stateList){
            System.out.println(w.getText());
        }


    }
}
