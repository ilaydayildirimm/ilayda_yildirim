package pages;

import base.BaseTest;
import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseTest {

    WebDriver driver;

    private String cardNoCredentialXpath = "//*[@name=\"userCardNo\"]";
    private String passwordCredentialXpath = "//*[@name=\"userPassword\"]";
    private String loginButtonXpath = "//*[@id=\"loginbutton\"]";
    private String popupXpath = "//*[@class=\"modalTitle___WE5UD\"]";
    private String createAccountButtonXpath = "//*[@class=\"signUp___3OOhy\"]";
    private String firstnameXpath = "//*[@name=\"name\"]";
    private String lastnameXpath = "//*[@name=\"surname\"]";
    private String emailXpath = "//*[@name=\"email\"]";
    private String telephonenumberXpath = "//*[@name=\"gsmNumber\"]";
    private String firstRadioButtonXpath = "//*[@name=\"checkBox1\"]";
    private String secondRadioButtonXpath = "//*[@name=\"checkBox2\"]";
    private String thirdRadioButtonXpath = "//*[@name=\"checkBox3\"]";
    private String continueButtonXpath = "//*[@id=\"continue_from_signup\"]";
    private String firstInput = "//*[@name=\"input1\"]";
    private String secondInput = "//*[@name=\"input2\"]";
    private String thirdInput = "//*[@name=\"input3\"]";
    private String fourthInput = "//*[@name=\"input4\"]";
    private String fifthInput = "//*[@name=\"input5\"]";
    private String sixthInput = "//*[@name=\"input6\"]";
    private String approveButton = "//*[@id=\"continue_from_otp\"]";
    private String errorMessage = "//*[@id=\"errorVerificationNo\"]";



    public LoginPage()
    {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void enterCardNumber(String cardNumber) {
        sendKeys(driver.findElement(By.xpath(cardNoCredentialXpath)),cardNumber);
    }

    public void enterPassword(String password) {
        sendKeys(driver.findElement(By.xpath(passwordCredentialXpath)),password);

    }
    public void clickLoginButton() {
        click(driver.findElement(By.xpath(loginButtonXpath)));
    }

    public void assertWarningMessage() {
        Assertion(driver.findElement(By.xpath(popupXpath)),"Hatalı bilgi girişi yaptınız.Lütfen bilgilerinizi kontrol ediniz." );
    }

    public void clickCreateAccountButton() throws InterruptedException {
        Thread.sleep(5000);
        scrollDown(1000);
        click(driver.findElement(By.xpath(createAccountButtonXpath)));
    }




    public void entersignincredential(String firstname, String lastname, String email, String telephonenumber) {
        sendKeys(driver.findElement(By.xpath(firstnameXpath)),firstname);
        sendKeys(driver.findElement(By.xpath(lastnameXpath)),lastname);
        sendKeys(driver.findElement(By.xpath(emailXpath)),email);
        sendKeys(driver.findElement(By.xpath(telephonenumberXpath)),telephonenumber);
    }

    public void clickAllRadioButtons() {
        click(driver.findElement(By.xpath(firstRadioButtonXpath)));
        click(driver.findElement(By.xpath(secondRadioButtonXpath)));
        click(driver.findElement(By.xpath(thirdRadioButtonXpath)));
    }

    public void clickContinueButton() throws InterruptedException {
        scrollDown(1000);
        click(driver.findElement(By.xpath(continueButtonXpath)));
    }

    public void enterOtpFields() {
        sendKeys(driver.findElement(By.xpath(firstInput)),"1");
        sendKeys(driver.findElement(By.xpath(secondInput)),"2");
        sendKeys(driver.findElement(By.xpath(thirdInput)),"3");
        sendKeys(driver.findElement(By.xpath(fourthInput)),"4");
        sendKeys(driver.findElement(By.xpath(fifthInput)),"5");
        sendKeys(driver.findElement(By.xpath(sixthInput)),"6");
    }

    public void clickApproveButton() {
        click(driver.findElement(By.xpath(approveButton)));
    }

    public void assertMessage() {
        Assertion(driver.findElement(By.xpath(errorMessage)),"Girdiğiniz onay kodu hatalıdır.");
    }
}
