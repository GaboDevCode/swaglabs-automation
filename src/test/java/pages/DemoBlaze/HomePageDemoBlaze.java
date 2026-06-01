package pages.DemoBlaze;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.FactoryWebElements;


public class HomePageDemoBlaze {

    private WebDriver driver;

    public HomePageDemoBlaze(WebDriver driver){

        this.driver = driver;

    }

    public void  openPage(){
        driver.get("https://www.demoblaze.com");

    }


    public WebElement getCategoria(String categoria) {

        By categoryLocator = By.xpath(
                "//a[@id='itemc' and normalize-space()='" + categoria + "']"
        );

        return FactoryWebElements.initialWithXpath(driver, categoryLocator);
    }

}
