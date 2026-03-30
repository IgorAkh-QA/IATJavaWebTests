package core.base;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class BasePage {

    protected SelenideElement notifications = $("div.notifications");
    protected SelenideElement searchFiled = $x("//input[@name='st.query']");

    public void search(String query) {
        searchFiled.setValue(query).pressEnter();
    }

    public void openNotifications() {
        notifications.click();
    }

}
