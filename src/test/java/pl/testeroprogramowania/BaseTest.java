package pl.testeroprogramowania;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("I´m running before test");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("I´m running before method");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("I´m after test");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("I´m after method");
    }

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I´m before suite");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("I´m before class");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("I´m after suite");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("I´m after class");
    }

}
