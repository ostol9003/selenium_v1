import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class imageTest {
    WebDriver driver;

    @Test
    public void imageTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement image = driver.findElement(By.tagName("img"));
        String height = image.getAttribute("naturalHeight");

        Assert.assertEquals(height,"0");




        driver.quit();
    }

}