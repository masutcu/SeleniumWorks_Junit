package day14NT_FakerClass_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void fileExist() {
        //masa üstünde bir dosya oluşturalım ve bu dosyanın varlığını doğrulayalım
        System.out.println("System.getProperty(\"user.dir\") = " + System.getProperty("user.dir"));//projemizin içinde bulunduğu yolu verir
        System.out.println("System.getProperty(\"user.home\") = " + System.getProperty("user.home"));//localimizdeki kullanıcı yolunu verir

        //String dosyaYolu = "C:\\Users\\Lenovo\\OneDrive\\Masaüstü\\b129.txt";//Shift'te basılı olarak sağ klik yapar dosya yolunu bir string'e assingn ederiz
        String farkliKisim = System.getProperty("user.home");//Her kullanıcının ana yolu farklı olduğuğu için farklı kısım dedik
        String ortakKisim = "\\OneDrive\\Masaüstü\\b129.txt";//Aynı yerde oluşturulduğu için ortakKısım dedik
        String dosyaYolu = farkliKisim+ortakKisim;//Dosya yolu olarak farkliKisim ve ortakkisimi aldık
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu))); //Files.exists methodu ile dosyanın varlığını doğruladık
    }
    }

