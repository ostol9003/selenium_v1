import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;


public class uploadFile {


    @Test
    public void uploadFile() throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://testeroprogramowania.github.io/selenium/");

        int randomNumber = (int) (Math.random()*1000);

        String beforeUpload = "beforeUpload" + randomNumber + ".jpg";
        String afterUpload = "afterUpload" + randomNumber + ".jpg";

        WebElement basicPageLink = driver.findElement(By.linkText("Załadowanie pliku"));
        basicPageLink.click();


        /*
        // Screenshot
        TakesScreenshot screenShoot = (TakesScreenshot) driver;
        File srcFile = screenShoot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("src/test/resources/"+beforeUpload));

        driver.findElement(By.id("myFile")).sendKeys("/Users/Ostol/ksiazki.txt");
        // alternativ sikuli

        srcFile = screenShoot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile,new File("src/test/resources/"+afterUpload));
        */

        driver.close();

    }
}
