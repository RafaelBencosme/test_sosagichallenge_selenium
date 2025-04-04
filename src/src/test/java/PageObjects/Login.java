package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends PageObjects {
    public Login(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userNameField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement logInButton;

    @FindBy(xpath = "//*[@id=\"login_button_container\"]/div/form/div[3]/h3")
    private WebElement userError;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void signIn(String username, String password) {
        userNameField.sendKeys(username);
        passwordField.sendKeys(password);
        logInButton.click();
    }

    public boolean hasLockedOutUserHelper() {
        return userError.isDisplayed();
    }

    public boolean hasInvalidCredentialsHelper() {
        return userError.isDisplayed();
    }

    public boolean hasEmptyCredentialsHelper() {
        return userError.isDisplayed();
    }

    public boolean hasLoginButton() {
        return loginButton.isDisplayed();
    }
}
