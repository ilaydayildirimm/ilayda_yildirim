package pages;

import base.BaseTest;
import base.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseTest {
    WebDriver driver;
    private String loginButtonXpath = "//*[@id=\"menu_login\"]";
    private String corporateLoginButtonXpath = "//*[@id=\"form1\"]/section[3]/div/div/div[1]/div/div[2]/a";

    public HomePage()
    {
        driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    public void clickLoginButton() {
        click(driver.findElement(By.xpath(loginButtonXpath)));

    }

    public void clickCorporateLoginButton() {
        scrollDown(1000);
        click(driver.findElement(By.xpath(corporateLoginButtonXpath)));

    }

}
