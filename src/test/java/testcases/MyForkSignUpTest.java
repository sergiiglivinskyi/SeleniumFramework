package testcases;

import org.testng.annotations.Test;

public class MyForkSignUpTest extends BaseTest{

    @Test
    public void verifyRoleDropdownContent() {
        myForkHomePage.openWebsite();
        myForkHomePage.openSignUpPage();
        myForkSignUpPage.getJobTitleDropdownValues();
        myForkSignUpPage.validateCorrectnessOfImplementation();
    }
}
