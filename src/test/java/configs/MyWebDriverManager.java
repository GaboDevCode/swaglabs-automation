package configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class MyWebDriverManager {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();


    public static WebDriver getDriver() {

        if (driver.get() == null) {

            WebDriverManager.chromedriver()
                    .driverVersion("149.0.7827.155")
                    .setup();

            System.out.println(
                    WebDriverManager.chromedriver().getDownloadedDriverPath()
            );

            ChromeOptions options = new ChromeOptions();

            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--incognito");

            Map<String, Object> prefs = new HashMap<>();

            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            prefs.put("profile.password_manager_leak_detection", false);

            options.setExperimentalOption("prefs", prefs);

           WebDriver  newDriver = new ChromeDriver(options);
           newDriver.manage().window().maximize();
           driver.set(newDriver);
        }

        return driver.get();
    }

    public static void quitDriver() {

        if (driver.get() != null){
            driver.get().quit();
            driver.remove();
        }
    }
}