package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver){
        super(driver);
    }
    By userNameLoginBy = By.id("user-name");
    By passwordFieldBy = By.id("password");
    By logInButtonBy = By.id("login-button");

    public void login(String userName, String pasSword){
        writeText(userNameLoginBy, userName);
        writeText(passwordFieldBy, pasSword);
        click(logInButtonBy);
    }
}
