package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Inventory extends PageObjects {
    public Inventory(WebDriver driver) {
        super(driver);
    }

    public void selectBackPack() {
        driver.findElement(By.id("item_4_title_link")).click();
    }

    public void selectAddToCart() {
        driver.findElement(By.id("add-to-cart")).click();
    }

    public void selectAddBackPackToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public void selectAddBikeLightToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
    }

    public void selectAddTShirtToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    public void selectAddFleeceJacketToCart(){
        driver.findElement(By.id("add-to-cart-sauce-labs-fleece-jacket")).click();
    }

    public boolean hasTittle() {
        return driver.findElement(By.className("title")).isDisplayed();
    }
}
