package interfaces;

import org.openqa.selenium.WebDriver;
import pajeobjects.BaseMain;

import java.util.logging.Logger;

public class Tester extends BaseMain implements Quizzes {

    public Tester(WebDriver driver, Logger logger) {
        super(driver, logger);
    }

    @Override
    public void quizName() {
        String quizNameTitle;
//        quizNameTitle = driver.findElement(By.xpath("//")).getText();
        quizNameTitle = "Manual Tester";
        System.out.println(quizNameTitle);
    }
}
