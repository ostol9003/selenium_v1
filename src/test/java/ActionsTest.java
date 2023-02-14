import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsTest {
    @Test
    public void actionsTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        Actions actions = new Actions(driver);

        // right button click
        actions.contextClick().perform();   // 1
        actions.contextClick(driver.findElement(By.id("bottom"))).perform();    // 2


        // double click
        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();

        driver.quit();
    }
}
