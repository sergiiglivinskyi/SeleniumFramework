package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OOP_Test {
    public ChromeDriver driver;

    //URLs
    String urlQaStartUp = "https://qastartup.us/";
    String urlBestBuy = "https://bestbuy.com";
    String urlBankOfAmerica = "https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG";

    //GUI elements
    String btnAccount = "//button[@id='account-menu-account-button']";
    String btnSignIn = "//a[text()='Sign In']";

    @BeforeTest
    public void startDriver() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        driver = new ChromeDriver();
    }

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
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnSignIn)).click();
    }
    @Test
    public void fillEmailAndPasswordFields() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Sign In']")).submit();
    }
    @Test
    public void fillEmailAndPasswordFieldAndPressEnter() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
    }
    @Test
    public void fillEmailAndPasswordFieldAndValidateError() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//div[@aria-label='Error']")).isDisplayed());
    }

    @Test
    public void fillEmailAndPasswordFieldAndValidateCheckbox() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("cia-remember-me")).isSelected());
    }
    @Test
    public void verifyCheckBox() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//label[@for='cia-remember-me']")).getText().contains("Keep me signed in."));
    }
    @Test
    public void isEnabled() throws InterruptedException {
        driver.get(urlBankOfAmerica);
        driver.findElement(By.xpath("//a[@name='Everyday_Banking']")).click();
        System.out.println("Close button is enabled: " + driver.findElement(By.xpath("//button[@id='nextBtnSubTopic']/preceding-sibling::button")).isEnabled());
        System.out.println("Next button is enabled: " + driver.findElement(By.xpath("//button[@id='nextBtnSubTopic']")).isEnabled());
    }

    @AfterTest
    public void closeBrowser() {
        driver.close();
    }
}

