package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class EmptyPasswordTest extends BaseTest{
    @Test
    public void emptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);

        String username = PropertyManager.getInstance().getLoginUsername();
        String emptyPassword = PropertyManager.getInstance().getEmptyPassword();

        loginPage.login(username,emptyPassword);

        try {
            verificationPage.verifyEmptyField("Epic sadface: Password is required");
            System.out.println("User is not logged in!!!");
        } catch (Exception e){
            Assert.fail();
        }
    }
}
