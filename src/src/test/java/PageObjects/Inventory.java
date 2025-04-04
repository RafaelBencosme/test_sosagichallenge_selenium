package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Inventory extends PageObjects {
    public Inventory(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "item_4_title_link")
    WebElement itemBackPack;

    @FindBy(id = "add-to-cart")
    WebElement addToCart;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackPackToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement addBikeLightToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    WebElement addTShirtToCart;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    WebElement addFleeceJacketToCart;

    @FindBy(className = "title")
    WebElement productsTitle;

    public void selectBackPack() {
        itemBackPack.click();
    }

    public void selectAddToCart() {
        addToCart.click();
    }

    public void selectAddBackPackToCart() {
        addBackPackToCart.click();
    }

    public void selectAddBikeLightToCart() {
        addBikeLightToCart.click();
    }

    public void selectAddTShirtToCart() {
        addTShirtToCart.click();
    }

    public void selectAddFleeceJacketToCart() {
        addFleeceJacketToCart.click();
    }

    public boolean hasTittle() {
        return productsTitle.isDisplayed();
    }
}
