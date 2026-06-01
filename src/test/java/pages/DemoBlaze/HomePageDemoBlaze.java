package pages.DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;

import java.util.List;


public class HomePageDemoBlaze {

    private static WebDriver driver;


    public HomePageDemoBlaze(WebDriver driver) {

        this.driver = driver;

    }

    public void openPage() {
        driver.get("https://www.demoblaze.com");

    }


    public WebElement getCategoria(String categoria) {

        By categoryLocator = By.xpath(
                "//a[@id='itemc' and normalize-space()='" + categoria + "']"
        );

        return FactoryWebElements.initialWithXpath(driver, categoryLocator);
    }



    public void seleccionarCategoria(String categoria) {
        getCategoria(categoria).click();

    }

    public int getProductsCount() {
        List<WebElement> products = FactoryWebElements.initialElementsWithXpath(
                driver,
                "//div[@class='card-block']"
        );
        return products.size();
    }


}
