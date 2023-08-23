package interfaces;

import org.openqa.selenium.WebDriver;
import pajeobjects.BaseMain;

import java.util.logging.Logger;

public class Developer extends BaseMain implements Quizzes{

    public Developer(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public void quizName() {
        String quizNameTitle;
//        quizNameTitle = driver.findElement(By.xpath("//")).getText();
        quizNameTitle = "Developer";
        System.out.println(quizNameTitle);
    }
}
