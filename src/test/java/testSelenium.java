import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Test;

public class testSelenium {


    @Test
    public void OpenGooglePage(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
    }
}
