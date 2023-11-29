package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class RemoveItemTest extends BaseTest{
    @Test

    public void removeItem () {
        LoginPage loginPage = new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);

        String username = PropertyManager.getInstance().getLoginUsername();
        String password = PropertyManager.getInstance().getLoginPassword();

        loginPage.login(username,password);

        try{
            verificationPage.verifyRemoveItem("Continue Shopping");
            System.out.println("You remove item!");
        }
        catch (Exception e) {
            Assert.fail("Something went wrong");
        }
    }
}
