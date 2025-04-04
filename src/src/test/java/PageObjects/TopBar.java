package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TopBar extends PageObjects {
    public TopBar(WebDriver driver) {
        super(driver);
    }

    public void logOut() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        driver.findElement(By.id("logout_sidebar_link")).click();
    }

    public void selectCartIcon() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }
}