package day12_WindowHandle_BasicAuth;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class C01_WindowHandle extends TestBase {
    @Test
    public void yeniTabTest(){

    //Tab 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());
    //Tab 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
    //Tab 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
    //techproeducation sayfasına geçiniz:
        //driver.switchTo().defaultContent();
        Set<String> codes=driver.getWindowHandles();
        System.out.println(codes);
        //Window handles bir set veriyor. Onu Array liste çeviriyoruz.
        List<String> windowHandleList= new ArrayList<>(driver.getWindowHandles());
        System.out.println(windowHandleList);

        driver.switchTo().window(windowHandleList.get(0));
        bekle(2);

    //youtube sayfasına geçiniz:
        driver.switchTo().window(windowHandleList.get(1));
        bekle(2);
    //linkedIn sayfasına geçiniz:
        driver.switchTo().window(windowHandleList.get(2));


    }
    @Test
    public void newTabTest2(){
        //Tab 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        Assert.assertEquals("Techpro Education | Online It Courses & Bootcamps",driver.getTitle());
        //Tab 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.google.com");
        Assert.assertEquals("Google",driver.getTitle());
        //Tab 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        Assert.assertTrue(driver.getTitle().contains("LinkedIn"));
        bekle(2);
        //techproeducation sayfasına geçiniz:
        switchToWindow(0);
        bekle(2);
        //youtube sayfasına geçiniz:
        switchToWindow(1);
        bekle(2);
        //linkedIn sayfasına geçiniz:
        switchToWindow(2);


}

}
