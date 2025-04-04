package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Checkout extends PageObjects {
    public Checkout(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstNameField;

    @FindBy(id = "last-name")
    WebElement lastNameField;

    @FindBy(id = "postal-code")
    WebElement zipCodeField;

    @FindBy(id = "continue")
    WebElement continueButton;

    @FindBy(id = "finish")
    WebElement finishButton;

    @FindBy(className = "complete-header")
    WebElement completeHeader;

    @FindBy(className = "error-button")
    WebElement formInvalidData;

    public void selectCheckout() {
        checkoutButton.click();
    }

    public void fillPersonalDataForm(
            String firstName,
            String lastName,
            String zipCode
    ) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        zipCodeField.sendKeys(zipCode);
        continueButton.click();
    }

    public void selectFinish() {
        finishButton.click();
    }

    public boolean hasCompletedPurchaseHeader() {
        return completeHeader.isDisplayed();
    }

    public boolean hasInvalidFormHelper() {
        return formInvalidData.isDisplayed();
    }
}
