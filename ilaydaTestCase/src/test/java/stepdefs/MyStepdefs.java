package stepdefs;

import base.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class MyStepdefs {

    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    private WebDriver driver;
    @Given("User navigates to home page")
    public void userNavigatesToHomePage() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        driver.get("https://param.com.tr");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @When("User clicks login button on Papara homepage")
    public void userClicksLoginButtonOnPaparaHomepage() {
        homePage.clickLoginButton();
    }

    @And("User clicks corporate login button on Papara page")
    public void userClicksCorporateLoginButtonOnPaparaPage() {
        homePage.clickCorporateLoginButton();
        homePage.ChangeTab();
    }

    @And("User enters {string} and {string} credentials on Papara login page")
    public void userEntersAndCredentialsOnPaparaLoginPage(String cardNumber, String password) {
        loginPage.enterCardNumber(cardNumber);
        loginPage.enterPassword(password);
    }
    @And("User clicks login button on Papara login page")
    public void userClicksLoginButtonOnPaparaLoginPage() {
        loginPage.clickLoginButton();
    }
    @Then("Notification should be seems directly")
    public void notificationShouldBeSeemsDirectly() {
        loginPage.assertWarningMessage();
    }


    @And("User clicks create account button on Papara login page")
    public void userClicksCreateAccountButtonOnPaparaLoginPage() throws InterruptedException {
        loginPage.clickCreateAccountButton();
    }

    @And("User enters {string}, {string} , {string}, {string} into credential fields on Papara sign in page")
    public void userEntersIntoCredentialFieldsOnPaparaSignInPage(String firstname, String lastname, String email, String telephonenumber) {
        loginPage.entersignincredential(firstname,lastname,email,telephonenumber);


    }

    @And("User clicks radio buttons on Papara sign in page")
    public void userClicksRadioButtonsOnPaparaSignInPage() {
        loginPage.clickAllRadioButtons();
    }

    @And("User clicks continue button on Papara sign in page")
    public void userClicksContinueButtonOnPaparaSignInPage() throws InterruptedException {
        loginPage.clickContinueButton();
    }

    @And("User enters otp fields on Papara sign in page")
    public void userEntersOtpFieldsOnPaparaSignInPage() {
        loginPage.enterOtpFields();
    }

    @And("User clicks approve button on Papara sign in page")
    public void userClicksApproveButtonOnPaparaSignInPage() {
        loginPage.clickApproveButton();
    }

    @Then("User should see error message on Papara sign in page")
    public void userShouldSeeErrorMessageOnPaparaSignInPage() {
        loginPage.assertMessage();
        driver.close();
    }
}
