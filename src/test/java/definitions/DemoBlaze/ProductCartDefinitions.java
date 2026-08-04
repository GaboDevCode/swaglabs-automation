package definitions.DemoBlaze;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.DemoBlaze.CartPageDemoBlaze;
import pages.DemoBlaze.CheckoutPageDemoBlaze;
import pages.DemoBlaze.HomePageDemoBlaze;
import pages.DemoBlaze.ProductPageDemoBlaze;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ProductCartDefinitions {


    private WebDriver driver;
    private HomePageDemoBlaze demoBlaze;
    private ProductPageDemoBlaze productPage;
    private CartPageDemoBlaze cartDemoBlaze;
    private CheckoutPageDemoBlaze checkout;

    @Before
    public void initPages() {
        driver = MyWebDriverManager.getDriver();
        demoBlaze = new HomePageDemoBlaze(driver);
        productPage = new ProductPageDemoBlaze(driver);
        cartDemoBlaze = new CartPageDemoBlaze(driver);
        checkout = new CheckoutPageDemoBlaze(driver);
    }



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


    // escenario  CriterioAc2

    @Given("que el usuario agrego los siguientes productos al carrito:")
    public void que_el_usuario_agrego_los_siguientes_productos_al_carrito(List<Map<String, String>> products) {


        for (Map<String, String> product : products) {

            String category = product.get("categoria");
            String nameProduct = product.get("producto");

            demoBlaze.openPage();
            demoBlaze.selectCategory(category);
            demoBlaze.selectProductCategory(nameProduct);
            productPage.addToCart();

        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        productPage.selectButtonCart().click();


    }

    @Then("debe visualizar que la suma de los productos coincida con el total esperado {string}")
    public void debe_visualizar_que_la_suma_de_los_productos_coincida_con_el_total_esperado(String total) {


        String getTotalCart = cartDemoBlaze.getPriceCart().getText().trim();
        System.out.println("Total esperado " + total);
        System.out.println("Total obtenido" + getTotalCart);

        int expectedTotal = Integer.parseInt(total);
        int displayedTotal = Integer.parseInt(getTotalCart);

        Assert.assertEquals("El total del carrito no coincide con el esperado", expectedTotal, displayedTotal);

        System.out.println("✅ Validación OK: el total coincide");


    }


    /**
     * escenario-CriterioAc3
     */
    @Given("que el usuario agrego el siguiente producto al carrito:")
    public void que_el_usuario_agrego_el_siguiente_producto_al_carrito(List<Map<String, String>> product) {

        String category = product.get(0).get("categoria");
        String nameProduct = product.get(0).get("producto");

        demoBlaze.selectCategory(category);
        demoBlaze.selectProductCategory(nameProduct);
        productPage.addToCart();
        productPage.selectButtonCart().click();


    }

    @Given("presiona el boton de compra {string}")
    public void presiona_el_boton_de_compra(String string) {


        productPage.selectedButtonPlaceOrder().click();


    }

    @Then("debe visualizar que el formulario muestre los siguientes campos:")
    public void debe_visualizar_que_el_formulario_muestre_los_siguientes_campos(io.cucumber.datatable.DataTable dataTable) {

        List<String> camposEsperados = dataTable.asList(String.class);

        for (String campo : camposEsperados) {
            Assert.assertTrue(
                    "El campo " + campo + " no se encuentra visible",
                    checkout.getDetailField(campo)
            );
        }
    }


}
