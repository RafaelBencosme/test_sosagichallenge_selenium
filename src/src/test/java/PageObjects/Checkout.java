package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout extends PageObjects{
    public Checkout(WebDriver driver){
        super(driver);
    }

    public void selectCheckout(){
        driver.findElement(By.id("checkout")).click();
    }

    public void fillPersonalDataForm(
            String firstName,
            String lastName,
            String zipCode
    ){
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
        driver.findElement(By.id("continue")).click();
    }

    public void selectFinish(){
        driver.findElement(By.name("finish")).click();
    }

    public boolean hasCompletedPurchaseHeader(){
        return driver.findElement(By.className("complete-header")).isDisplayed();
    }

    public boolean hasInvalidFormHelper(){
        return driver.findElement(By.className("error-button")).isDisplayed();
    }
}
