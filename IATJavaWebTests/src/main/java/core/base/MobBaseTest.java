package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class MobBaseTest extends AbstractBaseTest{

    @Override
    public void configure() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("mobileEmulation", Map.of("deviceName", "iPhone 14 Pro Max"));

        Configuration.browser = "chrome";
        Configuration.browserCapabilities = options;

        open(baseUrl);
    }
}



