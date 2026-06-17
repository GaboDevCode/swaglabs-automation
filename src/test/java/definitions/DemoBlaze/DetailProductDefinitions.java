package definitions.DemoBlaze;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoBlaze.HomePageDemoBlaze;
import pages.DemoBlaze.ProductPageDemoBlaze;
import utils.FactoryWebElements;

import java.time.Duration;

public class DetailProductDefinitions {

    private WebDriver driver;
    private HomePageDemoBlaze homePage;
    private ProductPageDemoBlaze productPage;

    public DetailProductDefinitions() {
        this.driver = MyWebDriverManager.getDriver(); // Obtiene el driver del Hook
        this.homePage = new HomePageDemoBlaze(driver);
        this.productPage = new ProductPageDemoBlaze(driver);
    }


    @When("selecciona un {string} de la categoria {string}")
    public void selecciona_un_de_la_categoria(String product, String category) {

        homePage.selectCategory(category);

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        } catch (Exception e) {
            e.printStackTrace();
        }

        homePage.selectProductCategory(product);


    }

    @Then("debe visualizar la informacion correcta del producto")
    public void debe_visualizar_la_informacion_correcta_del_producto(io.cucumber.datatable.DataTable dataTable) {

        var data = dataTable.asMap(String.class, String.class);

        String expectedName = data.get("nombre");
        String expectedPrice = data.get("precio");
        String expectedDescription = data.get("descripcion");

        String actualName = productPage.getNameProduct();
        String actualPrice = productPage.getPriceProduct();
        String actualDescription = productPage.getDescriptionProduct();

        Assert.assertEquals("❌ Product name does not match", expectedName, actualName);
        Assert.assertEquals("❌ Product price does not match", expectedPrice, actualPrice);
        Assert.assertTrue("❌ Product description does not contain expected text",
                actualDescription.contains(expectedDescription));

    }


}

