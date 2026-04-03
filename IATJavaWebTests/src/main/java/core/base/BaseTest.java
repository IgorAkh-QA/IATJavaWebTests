package core.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static org.openqa.selenium.remote.http.Route.options;

public class BaseTest {

    protected static String baseUrl;


    @BeforeEach
    public void setUp() {
        baseUrl = determineBaseUrl();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = options;
    }

    private static String determineBaseUrl() {
        String environment = System.getProperty("env", "test");
        String configFieldName = "application-" + environment + ".properties";

        Properties properties = new Properties();
        try (InputStream input =
                     BaseTest.class.getClassLoader().getResourceAsStream(configFieldName)) {
            if (input == null) {
                throw new IllegalStateException("Configuration file not found: " + configFieldName);
            }
            properties.load(input);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to load configuration file: " + configFieldName, e);
        }
        return properties.getProperty("baseUrl");
    }

    public String getBaseUrl() {
        return baseUrl;
    }


    @AfterEach
    public void tearDown() {
        closeWebDriver();
    }
}

