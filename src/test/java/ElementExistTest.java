import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ElementExistTest {
    WebDriver driver;

    @Test
    public void elementExistTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // exist?
        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));


        // is displayed ?
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        // is enabled?
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());
        System.out.println(driver.findElement(By.tagName("p")).isEnabled());

        // check checkbox
        System.out.println("################################");
        WebElement checkBox = driver.findElement(By.cssSelector("input[type=checkbox]"));
        System.out.println(checkBox.isSelected());
        checkBox.click();
        System.out.println(checkBox.isSelected());


        driver.quit();
    }

    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    public boolean elementExistSecond(By locator) {
          return  driver.findElements(locator).size() > 0;
    }
}