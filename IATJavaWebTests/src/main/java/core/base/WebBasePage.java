package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WebBasePage {

    protected SelenideElement headerLogo = $(".nohook_logo_link");
    protected SelenideElement searchFiled = $("#toolbar_search_input");

    @Step("Выполняем поиск по сайту с запросом: {query}")
    public void search(String query) {
        searchFiled.shouldBe(visible).setValue(query).pressEnter();
    }



}
