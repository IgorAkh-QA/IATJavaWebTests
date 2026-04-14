package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.WebBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class GroupsPageWeb extends WebBasePage {

    private SelenideElement userGroupsSearchResultList = $("#userGroupsSearchResultList");

    @Step("Проверяем доступность кнопки Создать группу")
    public void verifyUserGroupsSearchResultList(){
        userGroupsSearchResultList.shouldBe(visible);
    }

}
