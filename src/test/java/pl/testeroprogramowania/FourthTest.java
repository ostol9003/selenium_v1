package pl.testeroprogramowania;

import org.testng.annotations.Test;

public class FourthTest extends BaseTest {

    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest() {
        System.out.println("        First test");
    }

    @Test(dependsOnMethods = {"firstTest"})
    public void secondTest() {
        System.out.println("        Second test");
    }

    @Test
    public void thirdTest() {
        System.out.println("        Third test");
    }
}
