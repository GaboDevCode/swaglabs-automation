package pages.DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FactoryWebElements;

import java.time.Duration;
import java.util.Map;

public class CheckoutPageDemoBlaze {


    private WebDriver driver;

    public CheckoutPageDemoBlaze(WebDriver driver) {
        this.driver = driver;
    }

    public boolean getDetailField(String value) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Map<String, By> camp = Map.of(
                "Name", By.id("name"),
                "Country", By.id("country"),
                "City", By.id("city"),
                "Credit Card", By.id("card"),
                "Month", By.id("month"),
                "Year", By.id("year")
        );
        By locator = camp.get(value);

        if (locator == null) {
            throw new IllegalArgumentException(
                    "No existe un locator para el campo: " + value
            );
        }


        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();


    }

    public WebElement selectedButtonPurchase() {

        By buttonPurchase = By.xpath("//button[normalize-space()='Purchase']");

        return FactoryWebElements.initialClickableWithXpath(driver, buttonPurchase);
    }


    public String messagePurchase() {


        By messageCorrectPurchase = By.xpath("//h2[normalize-space()='Thank you for your purchase!']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(messageCorrectPurchase)).getText().trim();
        return message;

    }


    public void fillFormField(String fieldName, String value) {


        Map<String, By> camp = Map.of(
                "Name", By.id("name"),
                "Country", By.id("country"),
                "City", By.id("city"),
                "Credit Card", By.id("card"),
                "Month", By.id("month"),
                "Year", By.id("year")
        );
        By locator = camp.get(fieldName);

        if (locator == null) {
            throw new IllegalArgumentException(
                    "No existe un locator para el campo: " + fieldName
            );
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement field = wait.until(ExpectedConditions.elementToBeClickable(locator));
        field.clear();
        field.sendKeys(value);


    }

}
