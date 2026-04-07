package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import core.components.NavBarComponent;
import io.qameta.allure.Step;
import org.checkerframework.checker.units.qual.N;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPage extends BasePage {

    private SelenideElement userGroupsSearchResultList = $("#userGroupsSearchResultList");
    @Step("Проверяем доступность кнопки Создать группу")
    public void verifyUserGroupsSearchResultList(){
        userGroupsSearchResultList.shouldBe(visible);
    }

}
