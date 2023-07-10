package pajeobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BaseMain {
    public WebDriver driver;

    public BaseMain(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToTab(int tab) {
        List<String> tabHandler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabHandler.get(tab));
    }

    public void verticalScroll(int pixels){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")", "");
    }
}