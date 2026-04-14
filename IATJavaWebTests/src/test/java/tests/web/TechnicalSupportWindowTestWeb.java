package tests.web;

import core.pages.web.AnonymRecoveryPageWeb;
import core.base.WebBaseTest;
import core.pages.web.LoginPageWeb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechnicalSupportWindowTestWeb extends WebBaseTest {
    private static LoginPageWeb loginPage;
    private static AnonymRecoveryPageWeb anonymRecoveryPage;
    boolean expectedSupportWindowVisibility = true;


    @Test
    public void closeSupportChatWindowTest() {
        loginPage = new LoginPageWeb();
        loginPage.clickCantSignInButton();

        anonymRecoveryPage = new AnonymRecoveryPageWeb();
        anonymRecoveryPage.clickSupportMessageButton();
        boolean isSupportChatVisible = anonymRecoveryPage.isSupportChatVisible();
        assertEquals(isSupportChatVisible, expectedSupportWindowVisibility, "Окно обращения в службу поддержки не отображается");

        anonymRecoveryPage.clickExitSupportChatButton();
        anonymRecoveryPage.clickConfirmExitSupportChatWindowButton();
    }

}
