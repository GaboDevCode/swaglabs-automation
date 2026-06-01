package definitions.DemoBlaze;
import configs.MyWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.DemoBlaze.HomePageDemoBlaze;
import utils.FactoryWebElements;


public class DemoBlazeDefinitions {

    WebDriver driver = MyWebDriverManager.getDriver();
    HomePageDemoBlaze demoBlaze = new HomePageDemoBlaze(driver);

    private final By homeDemoBlaze = By.xpath("");

    @Given("que el usuario se encuentra en la página principal")
    public void que_el_usuario_se_encuentra_en_la_pagina_principal() {
        demoBlaze.openPage();
    }

    @Then("debe visualizar la categoria {string}")
    public void debe_visualizar_la_categoria(String categoria) {
        boolean test = demoBlaze.getCategoria(categoria).isDisplayed();
        Assert.assertTrue("La categoria <" + categoria + "> no esta desplegada en el Front", test);
    }


    @When("el usuario selecciona una {string}")
    public void el_usuario_selecciona_una(String categoria){

        demoBlaze.getCategoria(categoria);

    }

    @Then("debe visualizar al menos {int} productos")
    public void debe_visualizar_al_menos_productos(Integer cantidad) {

        int productsFront = demoBlaze.getProductsCount();

        Assert.assertTrue(
                "Se esperaban al menos " + cantidad + " productos pero se encontraron " + productsFront,
                productsFront >= cantidad
        );

    }


}
