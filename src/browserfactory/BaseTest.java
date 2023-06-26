package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    public void openBrowser(String baseUrl){
        //lunch browser
        driver = new ChromeDriver();
        //  open the URL in the browser
        driver.get(baseUrl);
        //maximise browser
        driver.manage().window().maximize();
        //we give implicit wait to driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    public void closeBrowser(){
        driver.quit();
    }
}


