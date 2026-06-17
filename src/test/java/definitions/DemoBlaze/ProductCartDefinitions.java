package definitions.DemoBlaze;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoBlaze.CartPageDemoBlaze;
import pages.DemoBlaze.HomePageDemoBlaze;
import pages.DemoBlaze.ProductPageDemoBlaze;

import java.time.Duration;
import java.util.List;

public class ProductCartDefinitions {


    WebDriver driver = MyWebDriverManager.getDriver();
    HomePageDemoBlaze demoBlaze = new HomePageDemoBlaze(driver);
    ProductPageDemoBlaze productPage = new ProductPageDemoBlaze(driver);
    CartPageDemoBlaze cartDemoBlaze = new CartPageDemoBlaze(driver);


    @Given("que el usuario se encuentra en la página principal de DemoBlaze")
    public void que_el_usuario_se_encuentra_en_la_página_principal_de_demo_blaze() {

        demoBlaze.openPage();
    }

    @Given("el usuario navega a la categoría {string}")
    public void el_usuario_navega_a_la_categoría(String categoria) {

        demoBlaze.getCategoria(categoria);
        demoBlaze.selectCategory(categoria);


    }

    @Given("selecciona el producto {string}")
    public void selecciona_el_producto(String producto) {

        demoBlaze.selectProductCategory(producto);
    }

    @When("agrega el producto al carrito")
    public void agrega_el_producto_al_carrito() {

        productPage.addToCart();


    }

    @When("navega al carrito")
    public void navega_al_carrito() {

        productPage.selectButtonCart().click();

    }

    @Then("debe visualizar el producto {string} con precio {int} en el carrito")
    public void debe_visualizar_el_producto_con_precio_en_el_carrito(String producto, Integer precio) {


        Assert.assertTrue(
                "El nombre del producto no fue encontrado en el carrito",
                cartDemoBlaze.getProductNameInCart().stream()
                        .map(String::trim)
                        .anyMatch(nombre -> nombre.equals(producto.trim()))
        );

        Assert.assertTrue(
                "El precio del producto no fue encontrado en el carrito",
                cartDemoBlaze.getProductPricesInCart().stream()
                        .map(String::trim)
                        .anyMatch(precioCarrito -> precioCarrito.equals(String.valueOf(precio)))
        );

    }

}
