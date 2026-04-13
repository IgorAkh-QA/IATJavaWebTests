package tests;

import core.base.BaseTest; 
import core.pages.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QrCodeShouldBeVisibleTest extends BaseTest {
    private static LoginPage loginPage;
    boolean expectedQrCodeVisibility = true;

    @Test
    public void qrCodeShouldBeVisibleTest(){
        loginPage = new LoginPage();
        loginPage.clickQrCodeLoginButton();
        boolean isQrCodeVisible = loginPage.isQrCodeVisible();
        assertEquals(expectedQrCodeVisibility, isQrCodeVisible, "Qr- code не найден на странице");
    }
}
