package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public abstract class PageObjects {
    protected WebDriver driver;

    public PageObjects(WebDriver driver){
        this.driver = driver;
        driver.get("https://www.saucedemo.com/");
        PageFactory.initElements(driver, this);
    }
}
