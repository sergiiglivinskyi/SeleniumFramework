package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BaseMain{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    //GUI elements XPaths
    String btnSignInLoginPage = "//button[text()='Sign In']";
    String fieldEmail = "//input[@type='email']";
    String fieldPassword = "//input[@type='password']";

    //Data to be inserted into the fields
    String dataEmail = "test@test.com";
    String dataPassword = "password";

    public void loginWithInvalidData() {
        driver.findElement(By.xpath(fieldEmail)).sendKeys(dataEmail);
        driver.findElement(By.xpath(fieldPassword)).sendKeys(dataPassword);
        driver.findElement(By.xpath(btnSignInLoginPage)).submit();
    }
}
