package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase_Lesson4HW {
    @Test
    //Open website
    public void openWebsite() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://test.my-fork.com/");
    }
    @Test
    //Open Sign In page using corresponding button on main page
    public void openSignInPage() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
    }
    @Test
    //Validate that Email field, Password field and Login button are displayed on Sign In page
    public void verifyElementsAreDisplayed() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        System.out.println("Email field is displayed: " + driver.findElement(By.xpath("//input[@id='email']")).isDisplayed());
        System.out.println("Password field is displayed: " + driver.findElement(By.xpath("//input[@id='password']")).isDisplayed());
        System.out.println("Login button is displayed: " + driver.findElement(By.xpath("//button[@type='submit' and text()='Log In']")).isDisplayed());
    }
    @Test
    //Enter invalid email and password in corresponding fields and click Log In button
    public void fillEmailAndPasswordFieldsAndSubmitForm() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit' and text()='Log In']")).submit();
    }
    @Test
    //Validate error is appeared after invalid email and password in corresponding fields and Log In button clicked
    public void fillEmailAndPasswordFieldAndValidateError() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit' and text()='Log In']")).submit();
        System.out.println("Error message: " + driver.findElement(By.xpath("//span[@class='invalid-feedback']")).getText());
    }
    @Test
    //Validate that Remember Me checkbox is checked by default
    public void verifyCheckBoxIsChecked() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumFramework/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://test.my-fork.com/");
        driver.findElement(By.xpath("//div[@id='log-in-button']/..")).click();
        System.out.println("Remember Me checkbox is checked: " + driver.findElement(By.xpath("//input[@id='auth-page-remember-me']")).isSelected());
    }
}