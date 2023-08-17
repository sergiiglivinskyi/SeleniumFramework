package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pajeobjects.*;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class BaseTest {

    RemoteWebDriver driver;
    Logger log;
    HomePage homePage;
    SignInPage signInPage;
    BankOfAmericaHomePage bankOfAmericaHomePage;
    MyForkHomePage myForkHomePage;
    MyForkSignUpPage myForkSignUpPage;
    MyForkSignInPage myForkSignInPage;
    MyForkCourseGalleryPage myForkCourseGalleryPage;
    MyForkQuizPage myForkQuizPage;
    AskQuestionPage askQuestionPage;

    @BeforeMethod(groups = {"checkbox", "login", "assertions", "driver"}, alwaysRun = true)
    @Parameters("browser")
    public void startDriver(@Optional("chrome") String browser) throws IOException {

        if(browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/src/test/resources/webdrivers/chromedriver");
            /*ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless=new");
            driver = new ChromeDriver(options);*/
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("sauce-chrome")) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-sergii.glivinskyi-28676");
            sauceOptions.put("accessKey", "e3ffb1a5-c463-48ff-8b51-87bf8152da28");
            sauceOptions.put("build", "selenium-build-6BCTK");
            sauceOptions.put("name", "First Sauce Test");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        } else if(browser.equalsIgnoreCase("sauce-edge")) {
            EdgeOptions browserOptions = new EdgeOptions();
            browserOptions.setPlatformName("Windows 11");
            browserOptions.setBrowserVersion("latest-1");
            Map<String, Object> sauceOptions = new HashMap<>();
            sauceOptions.put("username", "oauth-sergii.glivinskyi-28676");
            sauceOptions.put("accessKey", "e3ffb1a5-c463-48ff-8b51-87bf8152da28");
            sauceOptions.put("build", "Build 555");
            sauceOptions.put("name", "Edge execution");
            browserOptions.setCapability("sauce:options", sauceOptions);

            URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
            driver = new RemoteWebDriver(url, browserOptions);
        } else {
            System.out.println("Correct browser name was not provided, please check again");
        }

        log = Logger.getLogger(getClass().getName());
        saveLogs(log);

        homePage = new HomePage(driver, log);
        signInPage = new SignInPage(driver, log);
        bankOfAmericaHomePage = new BankOfAmericaHomePage(driver, log);
        myForkHomePage = new MyForkHomePage(driver, log);
        myForkSignUpPage = new MyForkSignUpPage(driver, log);
        myForkSignInPage = new MyForkSignInPage(driver, log);
        myForkCourseGalleryPage = new MyForkCourseGalleryPage(driver, log);
        myForkQuizPage = new MyForkQuizPage(driver, log);
        askQuestionPage = new AskQuestionPage(driver,log);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterMethod(groups = {"checkbox", "login", "assertions", "driver"}, alwaysRun = true)
    public void closeBrowser() {
        if(driver != null) {
            driver.quit();
        }
    }

    public void saveLogs(Logger log) throws IOException {
        FileHandler fileHandler = new FileHandler("/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/MyLogs.log");
        log.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
        log.info("==================THIS IS THE BEGINNING OF THE TEST==================");
    }

    @DataProvider(name = "LoginInfo")
    public static Object[][] getUserDataAndPageTitleName() throws IOException {
        return BaseMain.getTestData("LoginInfo.csv", 3);
    }
}