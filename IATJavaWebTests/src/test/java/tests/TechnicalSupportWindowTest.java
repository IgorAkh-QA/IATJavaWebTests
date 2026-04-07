package tests;

import core.pages.AnonymRecoveryPage;
import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TechnicalSupportWindowTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    boolean expectedSupportWindowVisibility = true;


    @Test
    public void closeSupportChatWindowTest() {
        loginPage = new LoginPage();
        loginPage.clickCantSignInButton();

        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.clickSupportMessageButton();
        boolean isSupportChatVisible = anonymRecoveryPage.isSupportChatVisible();
        assertEquals(isSupportChatVisible, expectedSupportWindowVisibility, "Окно обращения в службу поддержки не отображается");

        anonymRecoveryPage.clickExitSupportChatButton();
        anonymRecoveryPage.clickConfirmExitSupportChatWindowButton();
    }

}
