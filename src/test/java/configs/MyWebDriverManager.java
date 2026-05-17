package configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyWebDriverManager {

    private static WebDriver driver;

    public static WebDriver getDriver() {

        if (driver == null) {

            WebDriverManager.chromedriver()
                    .driverVersion("147.0.7727.101")
                    .setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-blink-features=AutomationControlled");

            driver = new ChromeDriver(options);

            driver.manage().window().maximize();
        }

        return driver;
    }

    public static void quitDriver() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}