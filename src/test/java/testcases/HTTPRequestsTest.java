package testcases;

import org.testng.annotations.Test;

public class HTTPRequestsTest extends BaseTest{

    @Test
    public void urlVerificationOnLoginPage() {
        myForkHomePage.openWebsite();
        myForkHomePage.openSignInPage();
        myForkSignInPage.urlVerification();
        myForkSignInPage.verifyServerStatusCodes(myForkSignInPage.urlVerification());
    }

    @Test
    public void urlVerificationOnSignUpPage() {
        myForkHomePage.openWebsite();
        myForkHomePage.openSignUpPage();
        myForkSignUpPage.urlVerification();
        myForkSignUpPage.verifyServerStatusCodes(myForkSignUpPage.urlVerification());
    }

    @Test
    public void urlVerificationOnCourseGalleryPage() {
        myForkHomePage.openWebsite();
        myForkHomePage.openCourseGalleryPage();
        myForkCourseGalleryPage.urlVerification();
        myForkCourseGalleryPage.verifyServerStatusCodes(myForkCourseGalleryPage.urlVerification());
    }
}