package testcases;

import org.testng.annotations.Test;

public class LoginFormTest extends BaseTest {
    @Test
    public void openSignInPage() {
        homePage.clickSignIn();
    }
    @Test
    public void fillEmailAndPasswordFields() {
        homePage.clickSignIn();
        signInPage.fillTheSignInForm();
    }
    @Test
    public void fillEmailAndPasswordFieldAndPressEnter() {
        homePage.clickSignIn();
        signInPage.loginWithPressEnter();
    }
    @Test
    public void fillEmailAndPasswordFieldAndValidateError() {
        homePage.clickSignIn();
        signInPage.loginWithPressEnter();
        signInPage.isErrorMessageDisplayed();
    }
    @Test
    public void fillEmailAndPasswordFieldAndValidateCheckbox() {
        homePage.clickSignIn();
        signInPage.isCheckboxRememberMeSelected();
    }
    @Test
    public void verifyCheckBox() {
        homePage.clickSignIn();
        signInPage.verifyCheckboxRememberMeText();
    }
}