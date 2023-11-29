package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class EmptyUserNameTest extends BaseTest{

    @Test
    public void emptyUserName(){
        LoginPage loginPage = new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);

        String emptyUsername = PropertyManager.getInstance().getEmptyUsername();
        String password = PropertyManager.getInstance().getLoginPassword();

        loginPage.login(emptyUsername,password);

      try {
          verificationPage.verifyEmptyField("Epic sadface: Username is required");
          System.out.println("User is not logged in!!!");
      } catch (Exception e) {
          Assert.fail("User is logged in!!!");
      }
    }
}
