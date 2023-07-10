package testcases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pajeobjects.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;
    BankOfAmericaHomePage bankOfAmericaHomePage;
    MyForkHomePage myForkHomePage;
    MyForkSignUpPage myForkSignUpPage;
    MyForkSignInPage myForkSignInPage;

    @BeforeTest
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
        bankOfAmericaHomePage = new BankOfAmericaHomePage(driver);
        myForkHomePage = new MyForkHomePage(driver);
        myForkSignUpPage = new MyForkSignUpPage(driver);
        myForkSignInPage = new MyForkSignInPage(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
    }

    @AfterTest
    public void closeBrowser() {
//        driver.quit();
    }
}