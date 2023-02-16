package pl.testeroprogramowania;

import org.testng.annotations.Test;

public class ThirdTest extends BaseTest {

    @Test(priority = 2)
    public void firstTest() {
        System.out.println("        First test");
    }

    @Test(priority = 1)
    public void secondTest() {
        System.out.println("        Second test");
    }

    @Test(priority = 0)
    public void thirdTest() {
        System.out.println("        Third test");
    }
}
