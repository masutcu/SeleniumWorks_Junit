package day14NT_FakerClass_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;

public class C02_JavaFaker {
    @Test
    public void faker() {
        //Faker objesi oluşturuyoruz
        Faker faker = new Faker();
        faker.name().firstName();
        //yada Faker.instance() static metodu ilede kullanabiliriz.
        Faker.instance().name().firstName();

        //username yazdıralım
        System.out.println(faker.name().username());

        //meslek ismi
        System.out.println(faker.name().title());
        //şehir ismi
        System.out.println(faker.address().city());

        //ülke ismi
        System.out.println(faker.address().country());
        //tam adress
        System.out.println(faker.address().fullAddress());
        //mobile number
        System.out.println(faker.phoneNumber().cellPhone());

        System.out.println(faker.animal().name());
        System.out.println(faker.number().digits(10)); //kaç basamaklı random sayi
        System.out.println(faker.internet().emailAddress());
        System.out.println(faker.name().bloodGroup());

    }
}