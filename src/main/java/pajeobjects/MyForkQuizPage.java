package pajeobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.logging.Logger;

public class MyForkQuizPage extends BaseMain{
    public MyForkQuizPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    //GUI elements XPaths
    private String answer = "//div[contains(@class, 'quiz-process-question-block-answers-block-item') and @data-answer-id='0'][1]";
    private String btnNext = "//div[text()='Next']";

    //Locators
    By answerLocator = By.xpath(answer);
    By progressValueLocator = By.id("quiz-process-progress-data");
    By btnNextLocator = By.xpath(btnNext);

    double totalNumberOfQuestions;


    public void selectTheAnswer() {
        driver.findElement(answerLocator).click();
    }

    private int getProgressValue() {
        String progressValueInString = driver.findElement(progressValueLocator).getText();
        String numberString = progressValueInString.replace("%", "").trim();
        return Integer.parseInt(numberString);
    }

    public void verifyProgressValue(double numberOfAnsweredQuestions) {
        totalNumberOfQuestions = MyForkCourseGalleryPage.getNumberOfQuestions();
        double correctValue = (numberOfAnsweredQuestions / totalNumberOfQuestions) * 100;
        Assert.assertEquals(getProgressValue(), (int)correctValue);
    }

    public void clickOnNextButton() {
        driver.findElement(btnNextLocator).click();
    }

    public void verifyQuizProgressBarForAllAnswers() {
        totalNumberOfQuestions = MyForkCourseGalleryPage.getNumberOfQuestions();
        for (int i = 1; i <= totalNumberOfQuestions; i++) {
            selectTheAnswer();
            verifyProgressValue(i);
            clickOnNextButton();
        }
    }
}