package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class LoginTest extends BaseTest {

    @Test
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);

        String username = PropertyManager.getInstance().getLoginUsername();
        String loginPassword = PropertyManager.getInstance().getLoginPassword();

        loginPage.login(username,loginPassword);

        try {
            verificationPage.verifyLogin("Open Menu");
            System.out.println("User is logged in!");
        }
        catch (Exception e){
            Assert.fail("Something went wrong!");
        }
    }
}

