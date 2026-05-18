package utils;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FactoryWebElements {

    public static WebElement initialWithXpath(WebDriver driver, By locator) {

        WebElement element = null;

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return element;
        } catch (Exception exception) {
            Assert.assertTrue("Elemento Web no encontrado <<" + exception + ">>", false);
        }
        return  element;
    }
}
