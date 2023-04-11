package day14NT_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownloadTEST extends TestBase {
    @Test
    public void fileDownload() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //https://testcenter.techproeducation.com/index.php?page=file-download    adresine gidelim.
        //b10 all test cases dosyasını indirelim
        //Dosyanın başarıyla indirilip indirilmediğini test edelim

        File sil=new File("\"C:\\Users\\Lenovo\\Downloads\\b10 all test cases, code.docx\"");
        sil.delete();
        //localinizden otomasyon ile bir dosya silmek için
        // File class ından obje oluşturup dosya yolumuzu içine yerleştiririz.
        // Oluşturduğumuz obje ile delete metodunu kullanarak o dosyayı silebiliriz.
        // Bunu yapma sebebimiz test clasımızı her çalıştırdığımızda yeni bir
        // dosya kayıt edeceği için doğrulama yaparken isimlendirmede işimizi garanti altına almış oluruz.
        driver.findElement(By.xpath("(//a)[3]")).click();
        String  dosyaaYolu=System.getProperty("user.home")+"/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaaYolu)));

    }
}
