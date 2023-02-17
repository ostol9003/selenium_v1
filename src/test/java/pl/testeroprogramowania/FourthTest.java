package pl.testeroprogramowania;

import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "data")
    public void dpTest(String val, String val2) {
        System.out.println(val+" " +val2);
    }


    @DataProvider(name = "data")
    public Object[][] dataProvider() {
        return new Object[][]{{"I am first test","First"},{"I am second test","Second"},{"I am third test","Third"}};
    }
}
