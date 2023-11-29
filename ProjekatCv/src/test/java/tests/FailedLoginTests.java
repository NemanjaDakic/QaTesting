package tests;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class FailedLoginTests extends BaseTest{

    @Test
    public void failedLogin() {

        LoginPage logInPage = new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);

        String username = PropertyManager.getInstance().getLoginUsername();
        String password = PropertyManager.getInstance().getBadLoginPassword();

        logInPage.login(username,password );


        try {
            verificationPage.verifyFailedLogin("Epic sadface: Username and password do not match any user in this service");
            System.out.println("User is not logged in!");
        } catch (Exception e){
            Assert.fail("Something went wrong");
        }

    }

}
