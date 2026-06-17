package definitions.SauceDemo;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.saucedemo.LoginPage;


public class TestLogin {

    WebDriver driver = MyWebDriverManager.getDriver();
    LoginPage loginPage = new LoginPage(driver);


    @Given("que el usuario se encuentra en la pantalla de login")
    public void que_el_usuario_se_encuentra_en_la_pantalla_de_login() {

        loginPage.openPage();

    }


    @Then("deberia ver el mensaje {string}")
    public void deberiaVerElMensaje(String mensaje) {


        Assert.assertEquals(
                mensaje,
                loginPage.getErrorMessage(mensaje));


    }

    @When("inicia sesión con usuario {string} y password {string}")
    public void inicia_sesión_con_usuario_y_password(String user, String password) throws InterruptedException {

        loginPage.login(user, password);
    }


    @Then("debe visualizar el catálogo de productos")
    public void debe_visualizar_el_catálogo_de_productos() throws InterruptedException {

        WebElement invetoryContainer = driver.findElement(By.id("inventory_container"));

        Assert.assertTrue(invetoryContainer.isDisplayed());

    }
}





