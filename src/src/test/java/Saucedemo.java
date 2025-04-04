import PageObjects.Checkout;
import PageObjects.Inventory;
import PageObjects.Login;
import PageObjects.TopBar;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.google.common.truth.Truth.assertThat;

public class Saucedemo {
    private WebDriver driver;
    private Login login;
    private Faker faker;
    private Inventory inventory;
    private TopBar topBar;
    private Checkout checkout;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        faker = new Faker();
        login = new Login(driver);
        inventory = new Inventory(driver);
        topBar = new TopBar(driver);
        checkout = new Checkout(driver);
    }

    @Test
    public void standard_User_ShouldBeAbleToLogin() {
        login.signIn("standard_user", "secret_sauce");

        assertThat(inventory.hasTittle()).isTrue();
    }

    @Test
    public void locked_Out_UserShouldNotBeAbleToLogin() {
        login.signIn("locked_out_user", "secret_sauce");

        assertThat(login.hasLockedOutUserHelper()).isTrue();
    }

    @Test
    public void problem_User_ShouldBeAbleToLogin() {
        login.signIn("problem_user", "secret_sauce");

        assertThat(inventory.hasTittle()).isTrue();
    }

    @Test
    public void performance_Glitch_User_ShouldBeAbleToLogin() {
        login.signIn("performance_glitch_user", "secret_sauce");

        assertThat(inventory.hasTittle()).isTrue();
    }

    @Test
    public void error_User_ShouldBeAbleToLogin() {
        login.signIn("error_user", "secret_sauce");

        assertThat(inventory.hasTittle()).isTrue();
    }

    @Test
    public void visual_User_ShouldBeAbleToLogin() {
        login.signIn("visual_user", "secret_sauce");

        assertThat(inventory.hasTittle()).isTrue();
    }

    @Test
    public void shouldNotBeAbleToLoginWithInvalidCredentials() {
        login.signIn("wrong username", "wrong pass");

        assertThat(login.hasInvalidCredentialsHelper()).isTrue();
    }

    @Test
    public void shouldNotBeAbleToLoginWithEmptyCredentials() {
        login.signIn("", "");

        assertThat(login.hasEmptyCredentialsHelper()).isTrue();
    }

    @Test
    public void shouldBeAbleToLogout() {
        login.signIn("standard_user", "secret_sauce");

        topBar.logOut();

        assertThat(login.hasLoginButton()).isTrue();
    }

    @Test
    public void shouldBeAbleToCompleteAPurchase() {
        login.signIn("standard_user", "secret_sauce");

        inventory.selectBackPack();
        inventory.selectAddToCart();

        topBar.selectCartIcon();

        checkout.selectCheckout();
        checkout.fillPersonalDataForm(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().zipCode()
        );
        checkout.selectFinish();

        assertThat(checkout.hasCompletedPurchaseHeader()).isTrue();
    }

    @Test
    public void shouldBeAbleToPurchaseMultipleItems() {
        login.signIn("standard_user", "secret_sauce");

        inventory.selectAddBackPackToCart();
        inventory.selectAddBikeLightToCart();
        inventory.selectAddTShirtToCart();
        inventory.selectAddFleeceJacketToCart();

        topBar.selectCartIcon();

        checkout.selectCheckout();
        checkout.fillPersonalDataForm(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.address().zipCode()
        );
        checkout.selectFinish();

        assertThat(checkout.hasCompletedPurchaseHeader()).isTrue();
    }

    @Test
    public void personalDataFormShouldHaveInvalidHelper() {
        login.signIn("standard_user", "secret_sauce");

        inventory.selectBackPack();
        inventory.selectAddToCart();

        topBar.selectCartIcon();

        checkout.selectCheckout();
        checkout.fillPersonalDataForm("", "", "");

        assertThat(checkout.hasInvalidFormHelper()).isTrue();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}