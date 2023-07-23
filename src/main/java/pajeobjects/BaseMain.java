package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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

    public void isElementDisplayedDependsOfLogin(By locator, boolean isLoggedIn) {
        if (isLoggedIn) {
            Assert.assertTrue(driver.findElement(locator).isDisplayed());
        } else {
            Assert.assertTrue(driver.findElements(locator).isEmpty());
        }
    }

    public void setListWithTextForImplementedValues(List<WebElement> webElements, List<String> implementedValuesInText, By locator) {
        webElements = driver.findElements(locator);
        for(WebElement element : webElements) {
            implementedValuesInText.add(element.getText());
        }
    }
}