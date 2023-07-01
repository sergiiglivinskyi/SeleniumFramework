package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyForkHomePage extends BaseMain{
    public MyForkHomePage(WebDriver driver) {
        super(driver);
    }

    //URLs
    String urlMyFork = "https://test.my-fork.com/";

    //GUI elements XPaths
    String btnSignUp = "//div[@id='sign-up-button']/..";

    public void openWebsite() {
        driver.get(urlMyFork);
    }

    public void openSignUpPage() {
        driver.findElement(By.xpath(btnSignUp)).click();
    }
}
