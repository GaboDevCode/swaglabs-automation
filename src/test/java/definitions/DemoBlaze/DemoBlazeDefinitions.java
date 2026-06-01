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

    WebDriver driver =  MyWebDriverManager.getDriver();
    HomePageDemoBlaze demoBlaze =  new HomePageDemoBlaze(driver);

    private final By homeDemoBlaze = By.xpath("");

    @Given("que el usuario se encuentra en la página principal de {string}")
    public void que_el_usuario_se_encuentra_en_la_página_principal_de(String string) {

        demoBlaze.openPage();

    }

    @Then("debe visualizar la categoria {string}")
    public void debe_visualizar_la_categoria(String categoria) {
        boolean test = demoBlaze.getCategoria(categoria).isDisplayed();
        Assert.assertTrue("La categoria <" + categoria + "> no esta desplegada en el Front", test);
    }

}
