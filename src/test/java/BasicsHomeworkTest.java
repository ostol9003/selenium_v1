import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasicsHomeworkTest {

    @Test
    public void homeworkTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // h1
        System.out.println(driver.findElement(By.tagName("h1")).getText());
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.tagName("h1"))).perform();
        // button
        driver.findElement(By.id("clickOnMe")).click();
        //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.switchTo().alert().accept();
        // input first name
        driver.findElement(By.name("fname")).sendKeys("Marcin");



        //driver.quit();
    }
}
