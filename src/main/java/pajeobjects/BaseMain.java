package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BaseMain {
    public WebDriver driver;
    public Logger log;

    public BaseMain(WebDriver driver, Logger logger) {
        this.driver = driver;
        this.log = logger;
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

    public void setListWithTextForImplementedValues(List<WebElement> webElements, List<String> implementedValuesInText) {
        for(WebElement element : webElements) {
            implementedValuesInText.add(element.getText());
        }
    }

    public void clickUsingXpath(String xpath, String elementName) {
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("Element: " + elementName + " was successfully clicked");
    }

    public void clickUsingWebElement(WebElement element, String elementName) {
        element.click();
        log.info("Element: " + elementName + " was successfully clicked");
    }

    public void typeUsingXpath(String xpath, String elementName, String value) {
        driver.findElement(By.xpath(xpath)).sendKeys(value);
        log.info("Value: " + value + " was successfully entered into " + elementName + " element");
    }
}