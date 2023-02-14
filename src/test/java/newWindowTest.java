import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Set;

public class newWindowTest {

    @Test
    public void NewWindowTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // get window name
        String currentWindow = driver.getWindowHandle();

        WebElement newWindow = driver.findElement(By.id("newPage"));
        newWindow.click();

        // get windows names
        Set<String> windowNames = driver.getWindowHandles();

        // get new window name
        for(String window : windowNames) {
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);}
        }

        driver.findElement(By.xpath("//div[text()='Zaakceptuj wszystko']")).click();
        WebElement searchInput = driver.findElement(By.cssSelector("[name='q']"));
        searchInput.sendKeys("Selenium");
        searchInput.sendKeys(Keys.ENTER);
        driver.switchTo().window(currentWindow);
        driver.findElement(By.name("fname")).sendKeys("Marcin");

    }
}
