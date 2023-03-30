package day07NT_Junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
    @Before
    public void setUp() throws Exception {
        System.out.println("Her test metodu öncesi çalışır");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her test metodu sonrası çalışır");

    }

    @Test
    public void test01() {
        System.out.println("ilk test");
    }

    @Test
    public void test02() {
        System.out.println("ikinci test");

    }

}
