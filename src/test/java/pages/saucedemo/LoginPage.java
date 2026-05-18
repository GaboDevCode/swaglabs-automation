package pages.saucedemo;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

public class LoginPage {

    private WebDriver driver;
    private final By userName = By.xpath("//*[@id=\"user-name\"]");
    private final By password = By.xpath("//*[@id=\"password\"]");
    private final By lgnButton = By.xpath("//*[@id=\"login-button\"]");
    private final By messageError = By.xpath("//form//*[contains(@class,'error-message-container')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {

        driver.get("https://www.saucedemo.com/");
    }

    public String getErrorMessage(String message) {
        return FactoryWebElements.initialWithXpath(driver, messageError)
                .getText();
    }

    public WebElement getInputUserName(WebDriver driver) {


        return FactoryWebElements.initialWithXpath(driver, userName);
    }

    public WebElement getInputUserPassword(WebDriver driver) {

        return FactoryWebElements.initialWithXpath(driver, password);
    }

    public WebElement submitPassword(WebDriver driver) {

        return FactoryWebElements.initialWithXpath(driver, lgnButton);
    }


    public void login(String user, String pass) {

        getInputUserName(driver).sendKeys(user);
        getInputUserPassword(driver).sendKeys(pass);
        submitPassword(driver).click();


    }


}


