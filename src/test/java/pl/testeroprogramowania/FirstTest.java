package pl.testeroprogramowania;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pl.testeroprogramowania.BaseTest;

import java.time.Duration;
import java.util.List;
@Listeners(value = {SampleTestListener.class})
public class FirstTest extends BaseTest {
    WebDriver driver;

    @Test //@Ignore
    public void firstTest() {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        waitForElementToExist(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));
        String paraText = driver.findElement(By.cssSelector("p")).getText();

// Hard asserts - stops when failed
        Assert.assertEquals(para.isDisplayed(),true);
        Assert.assertTrue(para.isDisplayed(),"Elemen is not displayed");
        Assert.assertTrue(para.getText().startsWith("Dopiero"));
        Assert.assertFalse(para.getText().endsWith("Dopiero"));
        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");
        Assert.assertEquals(paraText, "Dopiero","Teksty sa rozne");


        driver.quit();
    }

    @Test @Ignore
    public void secondTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

        waitForElementToExist(By.cssSelector("p"));

        WebElement para = driver.findElement(By.cssSelector("p"));
        String paraText = driver.findElement(By.cssSelector("p")).getText();

        Assert.assertEquals(paraText, "Dopiero się pojawiłem!");

        // Soft asserts - continues when failed
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(para.isDisplayed(),true);
        softAssert.assertTrue(para.isDisplayed(),"Elemen is not displayed");
        softAssert.assertTrue(para.getText().startsWith("Dopiero"));
        softAssert.assertEquals(para.getText(), "Dopiero","Teksty sa rozne");
        softAssert.assertFalse(para.getText().endsWith("Dopiero"));
        softAssert.assertEquals(para.getText(), "Dopiero się pojawiłem!");
        softAssert.assertEquals(para.getText(), "Dopiero sie","Teksty sa rozne");


        driver.quit();
        softAssert.assertAll();
    }

    public void waitForElementToExist(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); //  how often checking


        wait.until((driver) -> {
            List<WebElement> elements = driver.findElements(locator);
            if (elements.size() > 0) {
                System.out.println("Element found");
                return true;
            } else {
                System.out.println("Element not found");
                return false;
            }
        });
    }
}