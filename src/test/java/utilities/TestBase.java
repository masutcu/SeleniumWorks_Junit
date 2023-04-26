package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public abstract class TestBase {
    //TestBase class'ından Obje oluşturmanın önüne geçilmesi için abstract yapılabilir
    //Orn: TestBase base = new TestBase()
    //Bu class'a extends ettiğimiz test classlarından ulaşabiliriz
    protected static WebDriver driver;
    protected static ExtentReports extentReports; //Raporlamayı başlatır
    protected static ExtentHtmlReporter extentHtmlReporter;//Raporu HTML formatında düzenler
    protected static ExtentTest extentTest;//Tüm test aşamalarında extentTest objesi ile bilgi ekleriz
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //----------------------------------------------------------------------------------------
     //   extentReports = new ExtentReports();
     //   String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
     //   String dosyaYolu = "TestOutput/reports/extentReport_"+tarih+".html";
     //   extentHtmlReporter = new ExtentHtmlReporter(dosyaYolu);
     //   extentReports.attachReporter(extentHtmlReporter);
     //   //Raporda gözükmesini istediğimiz bilgiler için
     //   extentReports.setSystemInfo("Browser","Chrome");
     //   extentReports.setSystemInfo("Tester","MehmetAliSutcu");
     //   extentHtmlReporter.config().setDocumentTitle("Extent Report");
     //   extentHtmlReporter.config().setReportName("Smoke Test Raporu");
     //   extentTest=extentReports.createTest("ExtentTest","Test Raporu");
        //eğer extend report çalıştırılacaksa tearDown() daki extentReports.flush(); ıda aktif hale getirin
    }
    @After
    public void tearDown() throws Exception {
      //  extentReports.flush();
        bekle(3);
        // driver.quit();
    }
    //HARD WAIT METHOD
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Alert ACCEPT
    public static void alertAccept(){
        driver.switchTo().alert().accept();
    }
    //Alert DISMISS
    public static void alertDismiss(){
        driver.switchTo().alert().dismiss();
    }
    //Alert getText()
    public static void alertText(){
        driver.switchTo().alert().getText();
    }
    //Alert promptBox
    public static void alertprompt(String text){
        driver.switchTo().alert().sendKeys(text);
    }
    //DropDown VisibleText
    /*
        Select select2 = new Select(gun);
        select2.selectByVisibleText("7");
        //ddmVisibleText(gun,"7"); --> Yukarıdaki kullanım yerine sadece method ile handle edebilirim
     */
    public static void ddmVisibleText(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByVisibleText(secenek);
    }
    //DropDown Index
    public static void ddmIndex(WebElement ddm,int index){
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }
    //DropDown Value
    public static void ddmValue(WebElement ddm,String secenek){
        Select select = new Select(ddm);
        select.selectByValue(secenek);
    }
    //SwitchToWindow1
    public static void switchToWindow(int sayi){
        List<String> tumWindowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tumWindowHandles.get(sayi));
    }
    //SwitchToWindow2
    public static void window(int sayi){
        driver.switchTo().window(driver.getWindowHandles().toArray()[sayi].toString());
    }
    //EXPLICIT WAIT METHODS
    //Visible Wait
    public static void visibleWait(WebElement element,int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    //VisibleElementLocator Wait
    public static WebElement visibleWait(By locator, int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    //Alert Wait
    public static void alertWait(int sayi){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sayi));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    //Tüm Sayfa ScreenShot
    public static void tumSayfaResmi(){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/screenshot"+tarih+".png";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //WebElement ScreenShot
    public static void webElementResmi(WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "TestOutput/webElementScreenshot"+tarih+".png";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //bu method ile java script executer ile web element click yapılabilir.
    public void clickByJavaSc(WebElement webElement){
        JavascriptExecutor jse=(JavascriptExecutor) driver;//Casting
        jse.executeScript("arguments[0].click();",webElement);

    }
    //bu method ile java script executer ile sayfa kaydırma yapılabilir.
    public void scrollByJavaSc(WebElement webElement){
        JavascriptExecutor jse=(JavascriptExecutor) driver;//Casting
        jse.executeScript("arguments[0].scrollIntoView(true);",webElement);
    }
    //bu method ile java script kullanarak sayfa nın sonuna gidilebilir
    public void scrollEndByJc(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    //bu method ile java script kullanarak sayfa nın en üstüne gidilebilir
    public void scrollTopByJc(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //Bu method sendKeys() metodunun altarnatifi olup Java Script ile web elemente yazı göndermemizi sağlar
    public void typeWithJSc (String text,WebElement element) {

        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value'),'"+text+"')", element);

    }
    //Bu method ile attribute değerlerini alabilirim:
    public void getValueByJS(String id, String attributeName) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String attribute_Value = js.executeScript("return document.getElementById('" + id + "')." + attributeName).toString();
        System.out.println("Attribute Value: = " + attribute_Value);
//        NOT: document.querySelector("p").value;  -> TAG KULLANILABILIR
//             document.querySelector(".example").value; -> CSS DEGERI KULLANILABILIR
//             document.querySelector("#example").value; -> CSS DEGERI KULLANILABILIR

    }
    //Click Method hem javascript hem selenium
    public void click(WebElement element){
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();",element);
        }
    }
    //JS SendKeys
    public void sendKeysJS(WebElement element,String text){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='"+text+"'",element);

    }

}