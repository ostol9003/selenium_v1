import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.decorators.WebDriverDecorator;
import org.testng.annotations.Test;

public class iframeTest {
    @Test
    public void iframe() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        // main window name
        String windowName = driver.getWindowHandle();

        driver.findElement(By.linkText("Strona z iframe")).click();

        /*
            switch to iframe
            -by index
            -by name
            -by WebElement
        */

//        driver.switchTo().frame(0);
//        driver.switchTo().frame("");  // We don´t have attributes name or id

        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);

        driver.findElement(By.id("fname")).sendKeys("Marcin");

        /* 2 methods to switch to main window
         1 - need to know window name
         2 - switch to default content*/

        //driver.switchTo().window(windowName);
        driver.switchTo().defaultContent();

        System.out.println(driver.findElement(By.tagName("h1")).getText());

        driver.close();
    }
}
