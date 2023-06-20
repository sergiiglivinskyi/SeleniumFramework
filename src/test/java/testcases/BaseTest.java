package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pajeobjects.HomePage;
import pajeobjects.SignInPage;

public class BaseTest {

    WebDriver driver;
    HomePage homePage;
    SignInPage signInPage;

    @BeforeTest
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        signInPage = new SignInPage(driver);
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}
