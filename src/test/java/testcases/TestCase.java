package testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase {

    @Test
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qastartup.us/");
    }
}