package day11_Iframe_WindowHandle;

import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;

public class C03_WidowHandle2 extends TestBase {

    @Test
    public void newWindowTest() throws InterruptedException {
        //Window 1 de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproeducationWindowHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        assertEquals("Techpro Education | Online It Courses & Bootcamps", driver.getTitle());

        //Window 2'de https://www.youtube.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techpro sayfasına geçin
        Thread.sleep(2000);
        driver.switchTo().window(techproeducationWindowHandle);

        //youtube sayfasına geçin
        Thread.sleep(2000);
        driver.switchTo().window(youtubeWindowHandle);

        //linkedin sayfasına geçin
        Thread.sleep(2000);
        driver.switchTo().window(linkedinWindowHandle);






    }
}
