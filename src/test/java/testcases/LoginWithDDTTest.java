package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginWithDDTTest extends BaseTest{

    @Test(dataProvider = "LoginInfo")
    public void login(String username, String password, String expectedTitle) {
        myForkHomePage.openWebsite();
        myForkHomePage.openSignInPage();
        myForkSignInPage.loginWithCredentials(username, password);
        Assert.assertEquals(myForkHomePage.getTitle(), expectedTitle);
    }
}