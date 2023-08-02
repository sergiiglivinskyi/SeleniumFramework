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
    String btnSignIn = "//div[@id='log-in-button']/..";
    String linkCourseGallery = "//div[text()='Course Gallery']/..";

    public void openWebsite() {
        driver.get(urlMyFork);
    }

    public void openSignUpPage() {
        driver.findElement(By.xpath(btnSignUp)).click();
    }

    public void openSignInPage() {
        driver.findElement(By.xpath(btnSignIn)).click();
    }

    public void openCourseGalleryPage() {
        driver.findElement(By.xpath(linkCourseGallery)).click();
    }

    public void goToMainPage() {
        driver.get(urlMyFork);
    }

}
