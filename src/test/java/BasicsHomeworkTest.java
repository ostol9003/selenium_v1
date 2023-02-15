import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Set;

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

        // link text
        driver.findElement(By.linkText("Visit W3Schools.com!")).click();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // partial link text
        driver.findElement(By.partialLinkText("Iam")).click();

        // agree button + search "selenium"
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        WebElement searchInput = driver.findElement(By.cssSelector("[name='q']"));
        searchInput.sendKeys("selenium");
        searchInput.sendKeys(Keys.ENTER);

        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // print table
        System.out.print(driver.findElement(By.cssSelector("th:first-child")).getText());
        System.out.print(" " + driver.findElement(By.cssSelector("td:first-child")).getText());
        System.out.println();
        System.out.print(driver.findElement(By.cssSelector("th:last-child")).getText());
        System.out.print(" " + driver.findElement(By.cssSelector("td:last-child")).getText());

        // select car
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select car = new Select(selectCar);
        car.selectByValue("volvo");

        // checkbox
        driver.findElement(By.cssSelector("[type='checkbox']")).click();

        // radio
        driver.findElement(By.cssSelector("input[value='male']")).click();

        // Username + password
        WebElement usernameInput = driver.findElement(By.cssSelector("input[name='username']"));
        WebElement passwordInput = driver.findElement(By.cssSelector("input[name='password']"));
        usernameInput.clear();
        passwordInput.clear();
        usernameInput.sendKeys("marcin");
        passwordInput.sendKeys("password");
        passwordInput.sendKeys(Keys.ENTER);

        // Alerts
        driver.switchTo().alert().accept();
        driver.switchTo().alert().accept();

        // get window name
        String basicWindowName = driver.getWindowHandle();

        // click me + close new window
        driver.findElement(By.cssSelector("button[id='newPage']")).click();

        //get windows names
        Set<String> windowsNames = driver.getWindowHandles();

        //get new window name
        for(String name : windowsNames){
            if(!name.equals(basicWindowName)){
                driver.switchTo().window(name);
                driver.close();
            }
        }

        driver.quit();
    }
}
