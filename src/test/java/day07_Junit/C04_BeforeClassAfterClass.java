package day07_Junit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class C04_BeforeClassAfterClass {
    //BeforeClass ve After Class notasyonları sadece static medodlar ile çalışır.

    @BeforeClass
    public static void setUp(){
        System.out.println("Tüm teslerden önce 1 kez çalışır");
        System.out.println("====================");
    }

    @AfterClass
    public static void tearDown(){
        System.out.println("Tüm teslerden sonra 1 kez çalışır");
        System.out.println("====================");
    }



    @Test
    public void test1(){
        System.out.println("ilk test");
        System.out.println("=========");
    }
    @Test
    public void test2(){
        System.out.println("ikinci test");
        System.out.println("=========");
    }
    @Test
    public void test3(){
        System.out.println("üçüncü test");
        System.out.println("=========");
    }
}

