package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseMain{

    public HomePage(WebDriver driver){
        super(driver);
    }

    //URLs
    String urlBestBuy = "https://bestbuy.com";

    //GUI elements XPaths
    String btnAccount = "//button[@id='account-menu-account-button']";
    String btnSignInMainPage = "//a[text()='Sign In']";

    public void clickSignIn() throws InterruptedException {
        driver.get(urlBestBuy);
        driver.findElement(By.xpath(btnAccount)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(btnSignInMainPage)).click();
        Thread.sleep(1000);
    }
}