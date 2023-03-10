import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class actionsOnElements {

    @Test
    public void actions() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        // basics.html
        WebElement basicPageLink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPageLink.getText());
        basicPageLink.click();


        //driver.findElement(By.id("clickOnMe")).click();
        //driver.findElement(By.id("fname")).click();

        driver.findElement(By.id("fname")).sendKeys("Marcin");

        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear();
        usernameInput.sendKeys("admin");
        System.out.println(usernameInput.getAttribute("value"));

        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.clear();
        passwordInput.sendKeys("password");
        // Alerts
        passwordInput.sendKeys(Keys.ENTER);
        driver.switchTo().alert().accept(); // first
        driver.switchTo().alert().accept(); // second



        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();
        //driver.findElement(By.cssSelector("[value='saab']")).click();
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        //cars.selectByIndex(2);
        //cars.selectByVisibleText("Saab");
        cars.selectByValue("saab");

        List<WebElement> options = cars.getOptions();
//        for(WebElement option : options){
//            System.out.println(option.getText());
//        }
        System.out.println(homework(options,"Saab"));
        System.out.println(homework(options,"Fiat"));

        // Read hidden element

        WebElement para = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text: " + para.getText());
        System.out.println("By attr value: " + para.getAttribute("value"));
        System.out.println("By attr text content: " + para.getAttribute("innerText")); // textContent insted of



        driver.close();

    }

    public boolean homework(List<WebElement> list,String value){
        List<String> stringList = new ArrayList();

        for(WebElement option : list){
            stringList.add(option.getText());
        }
//        for(String a : stringList){
//            System.out.println(a);
//        }
        if(stringList.contains(value))
            return true;

        return false;
    }
}
