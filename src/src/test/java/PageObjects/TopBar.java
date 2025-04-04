package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopBar extends PageObjects {
    public TopBar(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "react-burger-menu-btn")
    WebElement burgerMenu;

    @FindBy(id = "logout_sidebar_link")
    WebElement logOut;

    @FindBy(id = "shopping_cart_container")
    WebElement cartIcon;

    public void logOut() {
        burgerMenu.click();
        logOut.click();
    }

    public void selectCartIcon() {
        cartIcon.click();
    }
}