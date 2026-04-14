package core.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public abstract class AbstractBaseTest {
    protected static String baseUrl;


    @BeforeEach
    public void setUp(){
        baseUrl = determineBaseUrl();
        configure();
    }

    public abstract void configure();

    public static String determineBaseUrl() {
        String environment = System.getProperty("env", "test");
        String configFieldName = "application-" + environment + ".properties";

        Properties properties = new Properties();
        try (InputStream input =
                     MobBaseTest.class.getClassLoader().getResourceAsStream(configFieldName)) {
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
