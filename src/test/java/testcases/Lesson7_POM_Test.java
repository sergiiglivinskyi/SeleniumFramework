package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pajeobjects.HomePage;
import pajeobjects.SignInPage;

public class Lesson7_POM_Test extends BaseTest {

    //URLs
    String urlQaStartUp = "https://qastartup.us/";
    String urlBestBuy = "https://bestbuy.com";
    String urlBankOfAmerica = "https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG";

    //GUI elements XPaths
    String btnAccount = "//button[@id='account-menu-account-button']";
    String btnSignInMainPage = "//a[text()='Sign In']";
    String btnSignInLoginPage = "//button[text()='Sign In']";
    String fieldEmail = "//input[@type='email']";
    String fieldPassword = "//input[@type='password']";
    String errorMessage = "//div[@aria-label='Error']";
    String checkboxRememberMeLabel = "//label[@for='cia-remember-me']";
    String topicEverydayBanking = "//a[@name='Everyday_Banking']";
    String btnClose = "//button[@id='nextBtnSubTopic']/preceding-sibling::button";
    String btnNext = "//button[@id='nextBtnSubTopic']";


    //GUI elements IDs
    String checkboxRememberMe = "cia-remember-me";

    //Data to be inserted into the fields
    String dataEmail = "test@test.com";
    String dataPassword = "password";

    //GUI elements text
    String checkboxRememberMeText = "Keep me signed in.";

    @Test
    public void startBrowser() {
        driver.get(urlQaStartUp);
    }
    @Test
    public void openWebsite() {
        driver.get(urlBestBuy);
    }
    @Test
    public void openSignInPage() throws InterruptedException {
        homePage.clickSignIn();
    }
    @Test
    public void fillEmailAndPasswordFields() throws InterruptedException {
        homePage.clickSignIn();
        signInPage.loginWithInvalidData();
    }
    @Test
    public void fillEmailAndPasswordFieldAndPressEnter() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnSignInMainPage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(fieldEmail)).sendKeys(dataEmail);
        driver.findElement(By.xpath(fieldPassword)).sendKeys(dataPassword);
        driver.findElement(By.xpath(fieldPassword)).sendKeys(Keys.ENTER);
    }
    @Test
    public void fillEmailAndPasswordFieldAndValidateError() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnSignInMainPage)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(fieldEmail)).sendKeys(dataEmail);
        driver.findElement(By.xpath(fieldPassword)).sendKeys(dataPassword);
        driver.findElement(By.xpath(fieldPassword)).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath(errorMessage)).isDisplayed());
    }

    @Test
    public void fillEmailAndPasswordFieldAndValidateCheckbox() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnSignInMainPage)).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id(checkboxRememberMe)).isSelected());
    }
    @Test
    public void verifyCheckBox() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnSignInMainPage)).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath(checkboxRememberMeLabel)).getText().contains(checkboxRememberMeText));
    }
    @Test
    public void isEnabled() throws InterruptedException {
        driver.get(urlBankOfAmerica);
        driver.findElement(By.xpath(topicEverydayBanking)).click();
        System.out.println("Close button is enabled: " + driver.findElement(By.xpath(btnClose)).isEnabled());
        System.out.println("Next button is enabled: " + driver.findElement(By.xpath(btnNext)).isEnabled());
    }
}