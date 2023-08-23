package interfaces;

import org.openqa.selenium.WebDriver;
import pajeobjects.BaseMain;

import java.util.logging.Logger;

public class Util extends BaseMain {

    public Quizzes quizzes;

    public Util(WebDriver driver, Logger logger, String quiz) {
        super(driver, logger);

        if(getClass().getName().contains("Developer") || quiz.contains("Developer")) {
            quizzes = new Developer(driver ,log);
        }

        if(getClass().getName().contains("Tester") || quiz.contains("QA")) {
            quizzes = new Tester(driver ,log);
        }
    }


}
