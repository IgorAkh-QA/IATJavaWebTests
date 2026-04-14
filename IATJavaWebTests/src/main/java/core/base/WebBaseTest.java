package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;

import static com.codeborne.selenide.Selenide.open;

public class WebBaseTest extends AbstractBaseTest{

    @Override
    public void configure() {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserCapabilities = options;

        open(baseUrl);
    }
}



