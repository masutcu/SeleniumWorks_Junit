package day07NT_Junit;

import org.junit.*;

public class C04_BeforeClassAfterClass {
    @BeforeClass
    public static void beforeClass(){
        System.out.println("tüm testlerden önce bir defa çalışır");
    }
    @AfterClass
    public static void afterClass(){
        System.out.println("her test metodundan sonra 1 defa çalışır");

    }
    @Before
    public void before(){
        System.out.println("Her testten önce çalışır");
    }
    @After
    public void after(){
        System.out.println("her testen sonra çalışır");

    }
    @Test
    public void test01(){
        System.out.println("ilk test metodu");
    }
    @Test
    public void test02(){
        System.out.println("ikinci test metodu");
    }
}
