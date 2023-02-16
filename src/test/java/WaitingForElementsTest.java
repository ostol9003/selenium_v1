import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.Test;

import javax.management.StandardMBean;
import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public class WaitingForElementsTest {
    WebDriver driver;

    @Test
    public void waitTest() throws InterruptedException {
        driver = new ChromeDriver();

//  implicit wait - more elastic better than sleep, defined for whole script
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();

//  sleep() specified waiting time - not recomended
//        Thread.sleep(5000);

//  explicit wait - can be defined in specified place
        Duration duration = Duration.ofMillis(10000);
//        WebDriverWait wait = new WebDriverWait(driver,duration);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));

//  fluent wait - must declare what to ignore
/*
        FluentWait<WebDriver> wait1 = new FluentWait<>(driver);
        wait1.ignoring(NoSuchElementException.class);
        wait1.withTimeout(duration);
        wait1.pollingEvery(Duration.ofSeconds(1)); //  how often checking
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
*/

//   Expected condition - visibility

  /*      FluentWait<WebDriver> wait1 = new FluentWait<>(driver);
        wait1.ignoring(NoSuchElementException.class);
        wait1.withTimeout(duration);
        wait1.pollingEvery(Duration.ofSeconds(10)); //  how often checking
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p")));
*/
//    Own conditions
        waitForElementToExist(By.cssSelector("p"));

        driver.quit();
    }

    public void waitForElementToExist(By locator){
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1)); //  how often checking

       /* wait.until(new Function<WebDriver, Boolean>() {
            @Override
            public Boolean apply(WebDriver webDriver) {
                List<WebElement> elements = driver.findElements(locator);
                if(elements.size()>0){
                    System.out.println("Element found");
                    return true;
                }else {
                    System.out.println("Element not found");
                    return false;
                }
            }
        });*/


//        lambda

        wait.until((driver) ->{
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
