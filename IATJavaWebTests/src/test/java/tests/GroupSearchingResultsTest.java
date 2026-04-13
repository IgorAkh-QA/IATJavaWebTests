package tests;


import core.base.BaseTest;
import core.components.AnonymHeaderPanelComponent;
import core.components.NavBarComponent;
import core.pages.GroupsPage;
import core.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupSearchingResultsTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymHeaderPanelComponent anonymHeaderPanelComponent;
    private static NavBarComponent navBarComponent;
    String value = "Тестировщик";

    @Test
    public void openGroupFromSearchSuggestsTest() {
        loginPage = new LoginPage();
        loginPage.verifyPageElements();
        anonymHeaderPanelComponent = new AnonymHeaderPanelComponent();

        anonymHeaderPanelComponent.headerSearchInputSetValue(value);
        anonymHeaderPanelComponent.verifySearchSuggest();
        anonymHeaderPanelComponent.verifySearchResults(value);
        anonymHeaderPanelComponent.getSuggestElementByValue(value).click();

        GroupsPage groupsPage = new GroupsPage();
        groupsPage.verifyUserGroupsSearchResultList();

        navBarComponent = new NavBarComponent();
        navBarComponent.verifyAllNavBarItemsVisible();
        navBarComponent.verifyActiveItem(navBarComponent.groupsItem, "Группы");
    }

}
