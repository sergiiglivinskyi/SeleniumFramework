package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BaseMain{

    public SignInPage(WebDriver driver) {
        super(driver);
    }

    //GUI elements XPaths
    String btnSignInLoginPage = "//button[text()='Sign In']";
    String fieldEmail = "//input[@type='email']";
    String fieldPassword = "//input[@type='password']";
    String errorMessage = "//div[@aria-label='Error']";
    String checkboxRememberMeLabel = "//label[@for='cia-remember-me']";

    //Data to be inserted into the fields
    String dataEmail = "test@test.com";
    String dataPassword = "password";

    //GUI elements IDs
    String checkboxRememberMe = "cia-remember-me";

    //GUI elements text
    String checkboxRememberMeText = "Keep me signed in.";

    private void fillEmailAndPassword(String emailValue, String passwordValue) {
        driver.findElement(By.xpath(fieldEmail)).sendKeys(emailValue);
        driver.findElement(By.xpath(fieldPassword)).sendKeys(passwordValue);
    }

    public void fillTheSignInForm() {
        fillEmailAndPassword(dataEmail, dataPassword);
        driver.findElement(By.xpath(btnSignInLoginPage)).submit();
    }

    public void loginWithPressEnter() throws InterruptedException{
        fillEmailAndPassword(dataEmail, dataPassword);
        driver.findElement(By.xpath(fieldPassword)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void isErrorMessageDisplayed() {
        System.out.println(driver.findElement(By.xpath(errorMessage)).isDisplayed());
    }

    public void isCheckboxRememberMeSelected() {
        System.out.println(driver.findElement(By.id(checkboxRememberMe)).isSelected());
    }

    public void verifyCheckboxRememberMeText() {
        System.out.println(driver.findElement(By.xpath(checkboxRememberMeLabel)).getText().contains(checkboxRememberMeText));
    }
}