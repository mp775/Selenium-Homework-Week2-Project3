package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setup() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //enter valid email
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");
        //enter valid password
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword!");
        //click on login button
        driver.findElement(By.xpath("//div[@class ='row']//i")).click();
        //verify message
        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.tagName("h2")).getText();
        Assert.assertEquals("Secure area text is not present", expectedText, actualText);
    }
    @Test
    public void verifyTheUsenameErrorMessage(){
        //enter email
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith1");
        //enter invalid password
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword");
        //click on login button
        driver.findElement(By.xpath("//div[@class ='row']//i")).click();
        //verify invalid password message
        String expectedMessage = "Your username is invalid!\n" +
                "×";
        String actualMessage = driver.findElement(By.id("flash")).getText();
        System.out.println(actualMessage);

        Assert.assertEquals("Invalid password message not display", expectedMessage, actualMessage);
    }


    @Test
    public void verifyThePasswordErrorMessage() {
        //enter email
        driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("tomsmith");
        //enter invalid password
        driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("SuperSecretPassword");
        //click on login button
        driver.findElement(By.xpath("//div[@class ='row']//i")).click();
        //verify invalid password message
        String expectedMessage = "Your password is invalid!\n" +
                "×";
        String actualMessage = driver.findElement(By.id("flash")).getText();
        System.out.println(actualMessage);

        Assert.assertEquals("Invalid password message not display", expectedMessage, actualMessage);
    }

    @After
    public void tearDown() {
        //closeBrowser();
    }
}
