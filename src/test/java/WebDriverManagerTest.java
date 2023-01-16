import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class WebDriverManagerTest {

    @Test
    public void openBrowser() {
//        SafariOptions options = new SafariOptions();
//        WebDriverManager.safaridriver().setup();
//        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);
        WebDriver driver = new SafariDriver();
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        executor.executeScript("alert('Hello')");


        driver.manage().window().maximize();
        driver.get("https://google.com");


        // Znalezienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));
        agreeButton.click();

        // Znalezienie pola wyszukiwania
        WebElement searchField = driver.findElement(By.name("q"));
        // Wprowadzenie wartosci do pola
        searchField.sendKeys("selenium");
        // Symulacja enter
        searchField.sendKeys(Keys.ENTER);

       driver.manage().timeouts().implicitlyWait(100,SECONDS);

        // Znalezc rezultat
        WebElement result = driver.findElement(By.xpath("//*[@id=\"hdtb-msb\"]/div[1]/div/div[2]/a"));
        result.click();
        Assert.assertTrue(result.isDisplayed());
        //        driver.close();
    }
}
