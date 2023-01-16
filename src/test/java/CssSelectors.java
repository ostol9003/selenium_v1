import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectors {

    @Test
    public void findElementsByCss(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement cssId = driver.findElement(By.cssSelector("#clickOnMe"));

        WebElement cssClass = driver.findElement(By.cssSelector(".topSecret"));

        WebElement cssTag = driver.findElement(By.cssSelector("input"));
        cssTag.sendKeys("first");

        WebElement cssName = driver.findElement(By.cssSelector("[name='fname']"));

        WebElement cssClass2 = driver.findElement(By.cssSelector("[class='topSecret']"));

        driver.quit();
    }

    @Test
    public void Css2(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");


    }
}
