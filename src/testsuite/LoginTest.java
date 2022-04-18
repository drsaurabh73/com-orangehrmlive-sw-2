package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp () { openBrowser(baseUrl);}

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


        // enter valid user name into username field
        WebElement userName = driver.findElement(By.id("txtUsername"));
        userName.sendKeys("Admin");
        // enter valid password into valid password field
        WebElement password = driver.findElement(By.name("txtPassword"));
        password.sendKeys("admin123");
        // click on login button
        WebElement loginButton = driver.findElement(By.xpath("//input[@id='btnLogin']"));
        loginButton.click();
        // verify the welcome text is display
        String expectedResult = "Welcome";
        System.out.println("Welcome");

        WebElement actualResultElement = driver.findElement(By.xpath("//a[@id='welcome']"));
        String acutalresult1 = actualResultElement.getText();

        String actualResult = acutalresult1.substring(0,7);
        System.out.println(actualResult);

        Assert.assertEquals("Welcome",actualResult,expectedResult);

    }
    @After
    public void tearDown () { closeBrowser();}
}
