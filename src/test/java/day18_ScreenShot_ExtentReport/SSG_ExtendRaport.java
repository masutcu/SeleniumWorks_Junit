package day18_ScreenShot_ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SSG_ExtendRaport extends TestBase {
    //extendreport için önce pom.xml e aventstack extendreport apache.poi dependency 'i yüklemek gerekir.

    @Test
    public void extentReportsTest() {
        //obje1
        ExtentReports extentReports=new ExtentReports();
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String path="TestOutput/reports/reports"+tarih+".html";//reports.html i yola biz ekledik
        //obje2
        ExtentHtmlReporter extentHtmlReporter=new ExtentHtmlReporter(path);
        //rapor süslemeler
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Tester","Memet Ali S");
        extentHtmlReporter.config().setReportName("Test Raporu");
        //obje3
        ExtentTest extentTest=extentReports.createTest("ExtentTest","Test Raporu");

        driver.get("https://amazon.com");

        extentTest.info("Amazon sayfasınaa gidildi");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Amazon sayfasında iphone aratıldı");
        driver.close();
        extentTest.pass("Test başarılı şekilde sonlandırıldı");
        extentReports.flush();

    }
}
