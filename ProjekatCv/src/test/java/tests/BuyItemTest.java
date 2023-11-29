package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.VerificationPage;
import utilities.PropertyManager;

public class BuyItemTest extends BaseTest{

    @Test

    public void buyItem() {
        LoginPage loginPage = new LoginPage(driver);
        VerificationPage verificationPage = new VerificationPage(driver);
        loginPage.login(PropertyManager.getInstance().getLoginUsername(), PropertyManager.getInstance().getLoginPassword());
        verificationPage.clickCartButton();
        verificationPage.clickShopingCartLink();
        verificationPage.clickCheckoutButton();
        verificationPage.inputInformation(PropertyManager.getInstance().getFirstName(), PropertyManager.getInstance().getLastName(), PropertyManager.getInstance().getZipPostalCod());
        verificationPage.clickContinueButton();

        try {
            verificationPage.verifyBuyItem("Back Home");
            System.out.println("Successful order!");
        } catch (Exception e) {
            Assert.fail("Something went wrong!");
        }
    }

}
