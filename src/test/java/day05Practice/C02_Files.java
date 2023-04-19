package day05Practice;


import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_Files  {

    // Desktop(masaustu)'da bir text dosyası olusturun
    // Desktop(masaustu)'da text dosyasının olup olmadıgını test edin
    //Herkesiz bilgisayarında farklı        Herkesin bilgisayarında aynı olan kısım
    //"C:\Users\Lenovo                      \Desktop\text"


    @Test
    public void test() {
    String farklıKısım=System.getProperty("user.home");
        System.out.println(farklıKısım);
        String ortakKısım="\\Desktop\\text";
        System.out.println(ortakKısım);

        String dosyaYolu=farklıKısım+ortakKısım;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        }
}
