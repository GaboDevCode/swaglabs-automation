package definitions;

import configs.MyWebDriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class TestLogin {


    WebDriver driver = MyWebDriverManager.getDriver();

    @Given("que el usuario se encuentra en la pantalla de login")
    public void que_el_usuario_se_encuentra_en_la_pantalla_de_login() {
            driver.get("https://www.saucedemo.com/");
    }
    @When("inicia sesión con usuario {string} y password {string}")
    public void inicia_sesión_con_usuario_y_password(String user, String password) {

        WebElement usernameInput = driver.findElement(By.id("user-name"));
        usernameInput.sendKeys(user);

        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.sendKeys(password);

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();


    }
    @Then("debe visualizar el catálogo de productos")
    public void debe_visualizar_el_catálogo_de_productos() {

     WebElement invetoryContainer = driver.findElement(By.id("inventory_container"));

     Assert.assertTrue(invetoryContainer.isDisplayed());

    }



}
