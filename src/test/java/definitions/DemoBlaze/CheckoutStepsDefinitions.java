package definitions.DemoBlaze;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.DemoBlaze.CheckoutPageDemoBlaze;
import pages.DemoBlaze.HomePageDemoBlaze;
import pages.DemoBlaze.ProductPageDemoBlaze;

import java.util.List;
import java.util.Map;

public class CheckoutStepsDefinitions {

    WebDriver driver = MyWebDriverManager.getDriver();
    HomePageDemoBlaze demoBlaze = new HomePageDemoBlaze(driver);
    ProductPageDemoBlaze productPage = new ProductPageDemoBlaze(driver);
    CheckoutPageDemoBlaze checkout = new CheckoutPageDemoBlaze(driver);


    @Given("que el usuario selecciona el producto {string} de la categoria {string} y lo agrega al carrito")
    public void que_el_usuario_selecciona_el_producto_de_la_categoria_y_lo_agrega_al_carrito(String nameProduct, String category) {


        demoBlaze.getCategoria(category);
        demoBlaze.selectCategory(category);
        demoBlaze.selectProductCategory(nameProduct);
        productPage.addToCart();
        productPage.selectButtonCart().click();
        productPage.selectedButtonPlaceOrder().click();
    }


    @When("el usuario registra sus datos en el formulario de compra")
    public void el_usuario_registra_sus_datos_en_el_formulario_de_compra(io.cucumber.datatable.DataTable dataTable) {


        List<Map<String, String>> purchaseInfo = dataTable.asMaps(String.class, String.class);
        Map<String, String> data = purchaseInfo.get(0);


        checkout.fillFormField("Name", data.get("name"));
        checkout.fillFormField("Country", data.get("country"));
        checkout.fillFormField("City", data.get("city"));
        checkout.fillFormField("Credit Card", data.get("creditCard"));
        checkout.fillFormField("Month", data.get("month"));
        checkout.fillFormField("Year", data.get("year"));


    }


    @When("confirma la compra")
    public void confirma_la_compra() {
        checkout.selectedButtonPurchase().click();

    }


    @Then("deberia ver el mensaje de confirmacion {string}")
    public void deberia_ver_el_mensaje_de_confirmacion(String messageExpected) {


        String messageRecived = checkout.messagePurchase();
        Assert.assertEquals("compra realizada con exito", messageExpected, messageRecived);
    }


}
