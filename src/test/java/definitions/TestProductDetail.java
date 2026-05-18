package definitions;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TestProductDetail {

    WebDriver driver = MyWebDriverManager.getDriver();

    @Given("que el usuario está en la pantalla de inventario")
    public void que_el_usuario_está_en_la_pantalla_de_inventario() throws InterruptedException {

        driver.get("https://www.saucedemo.com/inventory.html");
    }

    @When("selecciona un producto")
    public void selecciona_un_producto() throws InterruptedException  {

        driver.findElement(
                By.id("item_4_title_link")
        ).click();
    }

    @Then("debe visualizar el detalle del producto")
    public void debe_visualizar_el_detalle_del_producto()  throws InterruptedException {

        WebElement detail = driver.findElement(
                By.xpath("//div[contains(@class,'inventory_details_desc_container')]")
        );

        Assert.assertTrue(detail.isDisplayed());
    }
}
