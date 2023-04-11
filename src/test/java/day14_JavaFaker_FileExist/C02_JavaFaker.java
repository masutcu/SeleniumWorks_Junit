package day14_JavaFaker_FileExist;

import com.github.javafaker.Faker;
import org.junit.Test;
import utilities.TestBase;

public class C02_JavaFaker  {
   @Test
    public void javaFakerTest(){
       //1.Faker objesi oluştur
       Faker faker=new Faker();
       //yada Faker.instance() static metodu ile başlayabiliriz.
       Faker.instance().name(); //sahte isim veriyor

       //first name yazdıralım
      System.out.println(faker.name().firstName());

      //lastname yazdıralım
      System.out.println(Faker.instance().name().lastName());//static method ile

      //kullanıcı adı
      System.out.println(Faker.instance().name().username());

      //funny name
      System.out.println(faker.funnyName().name());

      //meslek ismi
      System.out.println(faker.name().title());

      //şehir ismi
      System.out.println(faker.address().city());

      //full adres
      System.out.println(faker.address().fullAddress());

      //cep numarası
      System.out.println(faker.phoneNumber().cellPhone());

      //email
      System.out.println(faker.internet().emailAddress());

      //posta kodu
      System.out.println(faker.address().zipCode());

      //rastgele 15 haneli numara yazdır
      System.out.println(faker.number().digits(15)); //parametre kadar haneli sayı verir
   }
}
