package pages.DemoBlaze;

import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FactoryWebElements;

import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CartPageDemoBlaze {

    private WebDriver driver;


    public CartPageDemoBlaze(WebDriver driver) {

        this.driver = driver;
    }


    public void waitForProductsLoaded() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                By.xpath("//tbody[@id='tbodyid']//tr"),
                0
        ));
    }

    public List<String> getProductNameInCart() {

        waitForProductsLoaded();

        return driver.findElements(By.xpath("//tbody[@id='tbodyid']//tr/td[2]"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

    }

    public List<String> getProductPricesInCart() {

        waitForProductsLoaded();

        return driver.findElements(By.xpath("//tbody[@id='tbodyid']//tr/td[3]"))
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public WebElement getPriceCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement price = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("totalp")));
        return price;
    }


}
