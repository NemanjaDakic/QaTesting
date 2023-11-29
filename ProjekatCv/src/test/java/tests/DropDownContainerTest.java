package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class DropDownContainerTest extends BaseTest{
    @Test

    public void sortContainer(){
        LoginPage loginPage= new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);

        String username = PropertyManager.getInstance().getLoginUsername();
        String password = PropertyManager.getInstance().getLoginPassword();

        loginPage.login(username,password);

        try {
            verificationPage.verifySortContainer("Add to cart");
            System.out.println("You sorted Item");
        }
        catch (Exception e){
            Assert.fail("Something went wrong");
        }

    }

}
