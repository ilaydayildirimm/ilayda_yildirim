package base;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseTest {
    private WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    public void click(WebElement clickELement){
        wait.until(ExpectedConditions.elementToBeClickable(clickELement)).click();

    }
    public void sendKeys(WebElement element,String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void Assertion(WebElement actual,String expected) {

        wait.until(ExpectedConditions.visibilityOf(actual));
        actual.getText().equals(expected);

        System.out.println("My message : " + actual.getText());

    }
    public void ChangeTab(){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        System.out.println("Şuan olduğum ekranın Url'i :" +driver.getCurrentUrl());

    }
    public void scrollDown(int i) {
        JavascriptExecutor jsx = (JavascriptExecutor)driver;
        jsx.executeScript("window.scrollBy(0,500)", "");
    }
}
