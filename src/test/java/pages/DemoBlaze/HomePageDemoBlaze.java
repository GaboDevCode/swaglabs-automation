package pages.DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FactoryWebElements;

import java.time.Duration;
import java.util.List;


public class HomePageDemoBlaze {

    private WebDriver driver;

    public HomePageDemoBlaze(WebDriver driver){

        this.driver = driver;

    }

    public void  openPage(){

        driver.get("https://www.demoblaze.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nava")));

    }


    public WebElement getCategoria(String categoria) {

        By categoryLocator = By.xpath(
                "//a[@id='itemc' and normalize-space()='" + categoria + "']"
        );

        return FactoryWebElements.initialWithXpath(driver, categoryLocator);
    }


    public void selectCategory(String categoria) {
        getCategoria(categoria).click();

    }

    public int getProductsCount() {
        List<WebElement> products = FactoryWebElements.initialElementsWithXpath(
                driver,
                "//div[@class='card-block']"
        );
        return products.size();
    }


    public void selectProductCategory(String nameProduct) {
        By productLocator = By.xpath("//a[contains(@class, 'hrefch') and normalize-space(text())='" + nameProduct + "']");

        WebElement product = FactoryWebElements.initialWithXpath(driver, productLocator);

        product.click();

    }




}
