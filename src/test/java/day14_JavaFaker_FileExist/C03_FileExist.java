package day14_JavaFaker_FileExist;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
      /*
    Masaüstünde "logo.jpeg" dosyası oluşturun.
    Bu dosyanın varlığını doğrulayın.
     */

    @Test
    public void fileExistTest() {
        String userDIR = System.getProperty("user.dir");//C:\Users\TechProEd\IdeaProjects\B129SeleniumMavenJunit
        //IDE proje yolunu dinamik olarak verir

        String userHOME = System.getProperty("user.home");//C:/Users/TechProEd(kullanıcı adı)
        //Kullanıcı adı yolunu dinamik olarak verir

        boolean isExist = Files.exists(Paths.get(userHOME + "/Desktop/logo.jpeg"));
        System.out.println("isExist = " + isExist);
        Assert.assertTrue(isExist);

        /*
        Fail ise: Dosya masaüstünde değil, dosya adı yanlış, yada arada onedrive gibi ekstra dosyalar olabilir.
         */

    }


}
