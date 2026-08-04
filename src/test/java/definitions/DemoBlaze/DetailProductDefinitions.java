package definitions.DemoBlaze;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import pages.DemoBlaze.HomePageDemoBlaze;
import pages.DemoBlaze.ProductPageDemoBlaze;

import java.time.Duration;

public class DetailProductDefinitions {

    private WebDriver driver;
    private HomePageDemoBlaze homePage;
    private ProductPageDemoBlaze productPage;


    @Before
    public void initPages() {
        this.driver = MyWebDriverManager.getDriver();
        this.homePage = new HomePageDemoBlaze(driver);
        this.productPage = new ProductPageDemoBlaze(driver);
    }


    @When("selecciona un {string} de la categoria {string}")
    public void selecciona_un_de_la_categoria(String product, String category) {

        homePage.selectCategory(category);

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

