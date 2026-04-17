package tests.web;

import core.base.WebBaseTest;
import core.pages.web.LoginPageWeb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodeShouldBeVisibleTestWeb extends WebBaseTest {
    private static LoginPageWeb loginPage;
    boolean expectedQrCodeVisibility = true;

    @Test
    public void qrCodeShouldBeVisibleTest(){
        loginPage = new LoginPageWeb();
        loginPage.clickQrCodeLoginButton();
        boolean isQrCodeVisible = loginPage.isQrCodeVisible();
        assertEquals(expectedQrCodeVisibility, isQrCodeVisible, "Qr- code не найден на странице");
    }
}
