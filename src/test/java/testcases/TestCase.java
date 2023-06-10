package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCase {

    @Test
    public void startBrowser() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://qastartup.us/");
    }
    @Test
    public void openWebsite() {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bestbuy.com/");
    }
    @Test
    public void openSignInPage() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bestbuy.com/");
        driver.findElement(By.xpath("//button[@id='account-menu-account-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
    }
    @Test
    public void fillEmailAndPasswordFields() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bestbuy.com/");
        driver.findElement(By.xpath("//button[@id='account-menu-account-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Sign In']")).submit();
    }
    @Test
    public void fillEmailAndPasswordFieldAndPressEnter() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bestbuy.com/");
        driver.findElement(By.xpath("//button[@id='account-menu-account-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);
    }
    @Test
    public void fillEmailAndPasswordFieldAndValidateError() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bestbuy.com/");
        driver.findElement(By.xpath("//button[@id='account-menu-account-button']")).click();
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
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bestbuy.com/");
        driver.findElement(By.xpath("//button[@id='account-menu-account-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.id("cia-remember-me")).isSelected());
    }
    @Test
    public void verifyCheckBox() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://bestbuy.com/");
        driver.findElement(By.xpath("//button[@id='account-menu-account-button']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[text()='Sign In']")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.xpath("//label[@for='cia-remember-me']")).getText().contains("Keep me signed in."));
    }
    @Test
    public void isEnabled() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/Users/serhii/Documents/SDET_COURSE/SeleniumProject/src/test/resources/chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://secure.bankofamerica.com/secure-mycommunications/public/appointments/?marketingCode=NEWHP_ECHMPG");
        driver.findElement(By.xpath("//a[@name='Everyday_Banking']")).click();
        System.out.println("Close button is enabled: " + driver.findElement(By.xpath("//button[@id='nextBtnSubTopic']/preceding-sibling::button")).isEnabled());
        System.out.println("Next button is enabled: " + driver.findElement(By.xpath("//button[@id='nextBtnSubTopic']")).isEnabled());
    }
}

