package testcases;

import org.openqa.selenium.WindowType;
import org.testng.annotations.Test;

public class TabAndScrollActionsTest extends BaseTest{

    @Test
    public void switchTabAndScrollDown() {
        driver.switchTo().newWindow(WindowType.TAB); //2nd
        driver.switchTo().newWindow(WindowType.TAB); //3rd
        driver.switchTo().newWindow(WindowType.TAB); //4th
        //Go to the 3rd tab
        switchToTab(2);
        driver.navigate().to("https://www.bestbuy.com/");
        verticalScroll(3000);
    }
}
