package core.components.web;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class NavBarComponent {
    public final List<String> items = List.of("Главная", "Видео", "Группы", "Люди", "Публикации", "Игры", "Подарки", "Поздравления", "Рекомендации");

    private SelenideElement navBar = $("[data-l=\"t,main\"]");
    public SelenideElement groupsItem = navBar.$("[data-l=\"t,userAltGroup\"]");

    @Step("Проверяем видимость всех элементов навбара")
    public NavBarComponent verifyAllNavBarItemsVisible() {
        for (String itemName : items) {
            navBar.$(byText(itemName)).shouldBe(visible);
        }
        return this;
    }

    @Step("Проверяем, что текущий элемент: {itemName} выбран активным")
    public NavBarComponent verifyActiveItem(SelenideElement navBarItem, String itemName) {
        navBarItem.shouldHave(attribute("data-active", "true"));
        return this;
    }
}

