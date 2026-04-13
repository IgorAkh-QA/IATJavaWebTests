package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class MobileBaseTest extends AbstractBaseTest{

    @Override
    public void configure() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "Samsung Galaxy S20 Ultra"));

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = options;

        open(baseUrl);
    }
}



