package day17_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_ScreenShot extends TestBase {
    @Test
    public void screenShot() throws IOException {
        /*
        Tüm Ekran görüntüsünü Selenium dan gelen getScreenShotAs methodu ile alırız.
        Bu method selenium daki TakesScreenShot arayüzünden(interface) gelir.
         */
        //techpro sayfasına gidelim.
        driver.get("https://techproeducation.com");
        //ilk olarak dosyayı nereye kaydedeceğimizi belirtiriz.
        String dosyaYolu="TestOutput/screenShot.png"; //proje seviyesinden new directory diyerek resimler için klasör açalım.
        //2. Adım TakesScreenshot arayüzünden obje oluşturmak
        TakesScreenshot ts= (TakesScreenshot) driver;
        //3. adım
        /*
        FileUtils classı file nesneleri ile birlikte kullanabileceğiniz metodlar içerir.
        Bu methodları kullanarak dosyalarda okuma, yazma, kopyalama ve silme işlemlerini çok daha kolay yapabiliriz.
        NOT: Files.write() methoduda aynı işlemi görür.
        */
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));

        //Ekran resmini projemize kaydedelim.
    }

    @Test
    public void test02() throws IOException {
        driver.get("https://amazon.com");
        TakesScreenshot ts= (TakesScreenshot) driver;
        //kaydettiğimiz klosöre kaydedeceğimiz dosyaları isimlendirirken unique olması için tarih ekleyebiliriz.
        String tarih=new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());

        String dosyaYolu="TestOutput/screenShot"+tarih+".png";

        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}
