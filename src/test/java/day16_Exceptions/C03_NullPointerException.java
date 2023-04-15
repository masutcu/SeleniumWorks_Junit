package day16_Exceptions;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import utilities.TestBase;

public class C03_NullPointerException extends TestBase {

        WebDriver driver;
        Faker faker;
        Integer number;
        String name;

        @Test
        public void nullPointerExceptionTest () {

            driver.get("https://www.techproeducation.com");//java.lang.NullPointerException ==> null değere sahip objeler üzerinde yapılan işlemler sonrası alınır.

        }

        @Test
        public void nullPointerExceptionTest2 () {
            // faker = new Faker();

            System.out.println(faker.number().numberBetween(1, 10));//java.lang.NullPointerException

        }

        @Test
        public void nullPointerExceptionTest3 () {

            //number = 4;
            System.out.println(number + 6);//java.lang.NullPointerException

        }

        @Test
        public void nullPointerExceptionTest4 () {

            //name = "Ali";
            System.out.println(name.charAt(0));//java.lang.NullPointerException

        }

    }
