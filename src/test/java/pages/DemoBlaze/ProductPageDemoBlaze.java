package pages.DemoBlaze;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FactoryWebElements;

import java.time.Duration;

public class ProductPageDemoBlaze {


    private final By nameProduct = By.xpath("//h2[@class='name']");
    private final By priceProduct = By.xpath("//h3[@class='price-container']");
    private final By productDescription = By.xpath("//*[@id='more-information']/p");

    private  WebDriver driver;

    public ProductPageDemoBlaze(WebDriver driver) {

        this.driver = driver;
    }


    public String getNameProduct() {

        return FactoryWebElements.initialWithXpath(driver, nameProduct).getText().trim();
    }


    public String getPriceProduct() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(priceProduct));
        String fullText = elem.getText();

        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\$\\d+(?:\\.\\d+)?");
        java.util.regex.Matcher m = p.matcher(fullText);
        if (m.find()) {
            return m.group();
        }
        return fullText; //
    }


    public String getDescriptionProduct() {
        return FactoryWebElements.initialWithXpath(driver, productDescription).getText().trim();
    }




    public WebElement selectedButton(String text) {

        By selectButton = By.xpath(
                "//a[contains(@class,'btn') and normalize-space()='" + text + "']"
        );

        return FactoryWebElements.initialWithXpath(driver, selectButton);
    }

    public void addToCart() {

        selectedButton("Add to cart").click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.alertIsPresent()).accept();

    }


    public WebElement selectButtonCart(){

        By selectedButtonCart = By.xpath("//*[@id=\"cartur\"]");

        return  FactoryWebElements.initialWithXpath(driver, selectedButtonCart);


    }
    }




