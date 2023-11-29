package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class LogoutTest extends BaseTest{

    @Test

   public void logout(){
        LoginPage loginPage = new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);

        String username = PropertyManager.getInstance().getLoginUsername();
        String password = PropertyManager.getInstance().getLoginPassword();

        loginPage.login(username,password);

        try {
            verificationPage.verifyLogout("Logout");
            System.out.println("User is logout!");

        }
        catch (Exception e){
            Assert.fail("Something went wrong!");
        }
    }
}
