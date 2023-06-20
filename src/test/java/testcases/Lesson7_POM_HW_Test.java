package testcases;

import org.testng.annotations.Test;

public class Lesson7_POM_HW_Test extends BaseTest {
    @Test
    public void openSignInPage() throws InterruptedException {
        homePage.clickSignIn();
    }
    @Test
    public void fillEmailAndPasswordFields() throws InterruptedException {
        homePage.clickSignIn();
        signInPage.fillTheSignInForm();
    }
    @Test
    public void fillEmailAndPasswordFieldAndPressEnter() throws InterruptedException {
        homePage.clickSignIn();
        signInPage.loginWithPressEnter();
    }
    @Test
    public void fillEmailAndPasswordFieldAndValidateError() throws InterruptedException {
        homePage.clickSignIn();
        signInPage.loginWithPressEnter();
        signInPage.isErrorMessageDisplayed();
    }
    @Test
    public void fillEmailAndPasswordFieldAndValidateCheckbox() throws InterruptedException {
        homePage.clickSignIn();
        signInPage.isCheckboxRememberMeSelected();
    }
    @Test
    public void verifyCheckBox() throws InterruptedException {
        homePage.clickSignIn();
        signInPage.verifyCheckboxRememberMeText();
    }
    @Test
    public void isEnabled() {
        bankOfAmericaHomePage.openWebsite();
        bankOfAmericaHomePage.openTopicEverydayBanking();
        bankOfAmericaHomePage.areButtonsEnabled();
    }
}