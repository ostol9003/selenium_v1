import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class findByCssSelectors {


//    @Test
//    public void findElementsByCss(){
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
//
//        WebElement cssId = driver.findElement(By.cssSelector("#clickOnMe"));
//
//        WebElement cssClass = driver.findElement(By.cssSelector(".topSecret"));
//
//        WebElement cssTag = driver.findElement(By.cssSelector("input"));
//        cssTag.sendKeys("first");
//
//        WebElement cssName = driver.findElement(By.cssSelector("[name='fname']"));
//
//        WebElement cssClass2 = driver.findElement(By.cssSelector("[class='topSecret']"));
//
//        driver.quit();
//    }

//    @Test
//    public void Css2() {
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
//
////        WebElement trInTable = driver.findElement(By.cssSelector("table tr"));
////        WebElement ulInDiv = driver.findElement(By.cssSelector("div ul"));
////        WebElement trInTbody = driver.findElement(By.cssSelector("tbody tr"));
////
////        WebElement firstChildUlInDiv = driver.findElement(By.cssSelector("div > ul"));
////        WebElement firstChildTrInTbody = driver.findElement(By.cssSelector("tbody > tr"));
////
////        WebElement firstFormAfterLabel = driver.findElement(By.cssSelector("label + form"));
////        List<WebElement> allFormsAfterLabel = driver.findElements(By.cssSelector("label ~ form"));
////        System.out.println(allFormsAfterLabel.size());
////
////
////        WebElement byAttrTag = driver.findElement(By.cssSelector("input[name='fname']"));
////        WebElement byAttrContains = driver.findElement(By.cssSelector("input[name*='nam']"));
////        WebElement byAttrStarts = driver.findElement(By.cssSelector("input[name^='f']"));
////        WebElement byAttrEnds = driver.findElement(By.cssSelector("input[name$='me']"));
//
//
//        By all = By.cssSelector("*");
//        driver.findElements(all);
//
//        By ulInsideDiv = By.cssSelector("div ul");
//        By trInTable = By.cssSelector("table tr");
//        By trInBody = By.cssSelector("tbody tr");
//
//        driver.findElement(ulInsideDiv);
//        driver.findElement(trInTable);
//        driver.findElement(trInBody);
//
//        By firstChildUlInDiv = By.cssSelector("div > ul");
//        By firstChildTrInTbody = By.cssSelector("tbody > tr");
//
//        driver.findElement(firstChildTrInTbody);
//        driver.findElement(firstChildUlInDiv);
//
//        By firstFormAfterLabel = By.cssSelector("label + form");
//        By allFormsAfterLabel = By.cssSelector("label ~ form");
//
//        driver.findElements(allFormsAfterLabel);
//        driver.findElements(firstFormAfterLabel);
//
//        driver.close();
//    }

    @Test
    public void Css3() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By attrTag = By.cssSelector("input[name = 'fname']");
        By attrContains = By.cssSelector("input[name*='ame']");
        By attrStarts = By.cssSelector("input[name^='f']");
        By attrEnds = By.cssSelector("input[name$='name']");

        driver.findElement(attrTag);
        driver.findElement(attrContains);
        driver.findElement(attrStarts);
        driver.findElement(attrEnds);
        driver.close();
    }
    @Test
    public void Css4() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By thirdChild = By.cssSelector("li:nth-child(3)");

        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);

        driver.close();
    }
}
