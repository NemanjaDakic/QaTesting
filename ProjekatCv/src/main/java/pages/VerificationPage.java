package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class VerificationPage extends BasePage {
    public VerificationPage(WebDriver driver) {
        super(driver);
    }

    By errorNotificationBy = By.xpath("//div[@class='error-message-container error']");
    By reactBurgerMenu = By.id("react-burger-menu-btn");
    By burgerMenuButton = By.id("react-burger-menu-btn");
    By logOutButton = By.id("logout_sidebar_link");
    By addToCart = By.name("add-to-cart-sauce-labs-fleece-jacket");
    By removeButton = By.name("remove-sauce-labs-fleece-jacket");
    By shoppingCartLink = By.className("shopping_cart_link");
    By continueShopping = By.id("continue-shopping");

    By checkoutButton = By.id("checkout");

    By firstName = By.id("first-name");

    By lastName = By.id("last-name");

    By zipPostalCod = By.id("postal-code");

    By continueButton = By.id("continue");

    By finishButton = By.id("finish");

    By backHome = By.id("back-to-products");

    By sortContainer = By.className("product_sort_container");

    By btnShirtRed = By.id("add-to-cart-test.allthethings()-t-shirt-(red)");


    public void verifyFailedLogin(String expectedText) {
        String error = readText(errorNotificationBy);
        assertStringEquals(error, expectedText);
    }

    public void verifyLogin(String expectedText) {
        String card = readText(burgerMenuButton);
        assertStringEquals(card, expectedText);
    }

    public void verifyEmptyField(String expectText) {
        String error = readText(errorNotificationBy);
        assertStringEquals(error, expectText);
    }

    public void verifyLogout(String expectedText) {
        click(reactBurgerMenu);
        String card = readText(logOutButton);
        assertStringEquals(card, expectedText);
    }

    public void verifyRemoveItem (String expectText){
        click(addToCart);
        click(removeButton);
        click(shoppingCartLink);
        String card = readText(continueShopping);
        assertStringEquals(card, expectText);
    }
    public void clickCartButton(){click(addToCart);}

    public void clickShopingCartLink(){click(shoppingCartLink);}

    public void clickCheckoutButton(){click(checkoutButton);}

    public void inputInformation(String fName, String lName, String zpCode){
        writeText(firstName, fName);
        writeText(lastName, lName);
        writeText(zipPostalCod, zpCode);}

    public void clickContinueButton(){click(continueButton);}

    public void verifyBuyItem (String expectedText){
        click(finishButton);
        String text = readText(backHome);
        assertStringEquals(text, expectedText);}

    public void verifySortContainer(String expectedText ){
        click(sortContainer);
        Select dropdown = new Select(driver.findElement(sortContainer));
        dropdown.selectByValue("za");
        String text = readText(btnShirtRed);
        assertStringEquals(text,expectedText);
    }
}