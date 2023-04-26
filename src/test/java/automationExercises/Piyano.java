package automationExercises;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Piyano extends TestBase {
   /*
   NOTA locate leri:
   Do   :driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
   Re   :driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
   Mi   :driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
   Fa   :driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
   Sol  :driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
   La   :driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
   Si   :driver.findElement(By.xpath("(//i[.='Si'])[2]")).click();
   Sib  :driver.findElement(By.xpath("(//span[.='Si'])[3]")).click();
    */

    @Test
    public void oldMcDonald() throws InterruptedException {
        driver.get("https://www.musicca.com/tr/piyano");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
    }

    @Test
    public void katibim() throws InterruptedException {
        driver.get("https://www.musicca.com/tr/piyano");
        Thread.sleep(2000);
        /*
        La sib la sol fa mi fa sol la sib la sol fa mi re
        La sib la sol fa mi fa sol la la la la
        La sib la sol fa mi fa sol la sib la sol fa mi re
        Mi sol fa mi mi re re do# re re re re

        Re la la la sib la sib do la la
        Sol sol sol fa sol la sib la sol fa mi re
        Re la la la sib la sib do la la
        Sol sol sol fa sol la

        Re mi fa sol la sib la sol fa mi re
        Mi sol fa mi mi re do# re mi fa mi re do# re mi
        Re mi fa sol la sib la sol fa mi re
        Mi sol fa mi mi re re do# re re re re

        mi fa mi re       do si do re     mi fa mi re     do si la    si re do si   si la sol la si
         */
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Si'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Si'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//i[.='Si'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Do'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Si'])[2]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("(//i[.='Si'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Si'])[2]")).click();
        Thread.sleep(2500);






        //

        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//span[.='Si'])[3]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//span[.='Si'])[3]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Re'])[2]")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//span[.='Si'])[3]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Mi'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Fa'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='Sol'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("(//i[.='La'])[2]")).click();
        Thread.sleep(500);



    }
}
