package definitions.hooks;



import configs.MyWebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

  @Before
    public void setUp(){
      MyWebDriverManager.getDriver();
  }


  @After
  public void tearDown(Scenario scenario) {
      if (scenario.isFailed()) {
          byte[] screenshot = ((TakesScreenshot) MyWebDriverManager.getDriver())
                  .getScreenshotAs(OutputType.BYTES);
          scenario.attach(screenshot, "image/png", scenario.getName());
      }
      MyWebDriverManager.quitDriver();
  }

}
