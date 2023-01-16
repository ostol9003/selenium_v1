import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

import java.util.List;

public class findElements {


    @Test
    public void FindElements(){
        WebDriver driver = new SafariDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");


        //clickOnMe

        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        //clickOnMeButton.click();

        //fname

        By firstName = By.name("fname");
        WebElement firstNameInput = driver.findElement(firstName);
        //firstNameInput.sendKeys("Marcin");

        //topSecret

        WebElement topSecret = driver.findElement(By.className("topSecret"));

        // input

        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("first");


        List<WebElement> inputs  = driver.findElements(By.tagName("input"));
        System.out.println(inputs.size());

        // link text

        WebElement linkText = driver.findElement(By.linkText("Visit W3Schools.com!"));
        WebElement linkText2 = driver.findElement(By.partialLinkText("Visit W3Schools"));
        //linkText.click();

        // find by css



    }
}
