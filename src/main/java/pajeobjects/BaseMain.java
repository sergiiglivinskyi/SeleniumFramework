package pajeobjects;

import org.openqa.selenium.WebDriver;

public class BaseMain {
    public WebDriver driver;

    public BaseMain(WebDriver driver) {
        this.driver = driver;
    }
}
