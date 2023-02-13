import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class findByXpath {


    @Test
    public void xpath_1() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By fullPath = By.xpath("/html/body/div/ul");
        driver.findElement(fullPath);

        By shortPath = By.xpath("//ul");
        driver.findElement(shortPath);

        By buttonId = By.xpath("/html/body/button[@id='clickOnMe']");
        driver.findElement(buttonId);

        By buttonId2 = By.xpath("//button[@id='clickOnMe']");
        driver.findElement(buttonId2);

        By firstName = By.xpath("//input[@name='fname']");
        driver.findElement(firstName);

        By paraHidden = By.xpath("/p[@class='topSecret']");
        driver.findElement(paraHidden);

        By inputLocator = By.xpath("//input");
        driver.findElement(inputLocator).sendKeys("Witaj!");

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']");
        driver.findElement(linkText);

        By partialText = By.xpath("//a[contains(text(),'Visit W3Schools.com!')]");
        driver.findElement(partialText);


        driver.close();
    }

    @Test
    public void xpath_2() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By allXpath = By.xpath("//*");
        driver.findElement(allXpath);

        By secondElement = By.xpath("(//input)[2]");
        driver.findElement(secondElement);

        By lastElement = By.xpath("(//input)[last()]");
        driver.findElement(lastElement);

        By elementWithAttr = By.xpath("(//*[@name]");
        driver.findElement(elementWithAttr);
    }

    @Test
    public void xpath_3() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

//        String test = "username";
//        String substring = test.substring(test.length()-2);
//        System.out.println(substring);

        By attrEq = By.xpath("//button[@id='clickOnMe']");
        By attrNotEq = By.xpath("//*[@id!='clickOnMe']");
        By attrCont = By.xpath("//*[contains(@name,'ame')]");
        By startsWith = By.xpath("//*[starts-with(@name,'user')]");
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('fname')+1)='fname']");
        // By endsWith2 = By.xpath("//*[ends-with(@name,'name')]");

        driver.findElement(attrEq);
        driver.findElement(attrNotEq);
        driver.findElement(attrCont);
        driver.findElement(startsWith);
        driver.findElement(endsWith);
        // driver.findElement(endsWith2); // xpath 2.0

        driver.close();
    }

    @Test
    public void xpath_4() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By child = By.xpath("//div/child::ul");
        By descendant = By.xpath("//div/descendant::*");
        By parent = By.xpath("//div/../..");
        By ancestor = By.xpath("//div/ancestor::*");
        By following = By.xpath("//img/following::*");
        By followingSibling = By.xpath("//img/following-sibling::*");
        By preceding = By.xpath("//img/preceding::*");
        By precedingSibling = By.xpath("//img/preceding-sibling::*");

        driver.findElement(child);
        driver.findElement(descendant);
        driver.findElement(parent);
        driver.findElement(ancestor);
        driver.findElement(following);
        driver.findElement(followingSibling);
        driver.findElement(preceding);
        driver.findElement(precedingSibling);

        driver.close();
    }

    @Test
    public void xpath_5() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By divsAndLinks = By.xpath("//div| //a");
        By andOp = By.xpath("//input[@name='fname' and @id='fname']");
        By orOp = By.xpath("//input[@name='surname' or @id='fname']");

        driver.findElement(divsAndLinks);
        driver.findElement(andOp);
        driver.findElement(orOp);

        By copyXpath = By.xpath("//button[@id=\"clickOnMe\"]");
        driver.findElement(copyXpath);

        driver.close();
    }

}
