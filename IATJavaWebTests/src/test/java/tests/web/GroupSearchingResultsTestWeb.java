package tests.web;


import core.base.WebBaseTest;
import core.components.web.AnonymHeaderPanelComponent;
import core.components.web.NavBarComponent;
import core.pages.web.GroupsPageWeb;
import core.pages.web.LoginPageWeb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupSearchingResultsTestWeb extends WebBaseTest {
    private static LoginPageWeb loginPage;
    private static AnonymHeaderPanelComponent anonymHeaderPanelComponent;
    private static NavBarComponent navBarComponent;
    String value = "Тестировщик";

    @Test
    public void openGroupFromSearchSuggestsTest() {
        loginPage = new LoginPageWeb();
        loginPage.verifyPageElements();
        anonymHeaderPanelComponent = new AnonymHeaderPanelComponent();

        anonymHeaderPanelComponent.headerSearchInputSetValue(value);
        anonymHeaderPanelComponent.verifySearchSuggest();
        anonymHeaderPanelComponent.verifySearchResults(value);
        anonymHeaderPanelComponent.getSuggestElementByValue(value).click();

        GroupsPageWeb groupsPage = new GroupsPageWeb();
        groupsPage.verifyUserGroupsSearchResultList();

        navBarComponent = new NavBarComponent();
        navBarComponent.verifyAllNavBarItemsVisible();
        navBarComponent.verifyActiveItem(navBarComponent.groupsItem, "Группы");
    }

}
