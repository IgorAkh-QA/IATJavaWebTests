package tests.mob;

import core.base.MobBaseTest;
import core.pages.mob.HelloPageMob;
import core.pages.mob.LoginPageMob;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithUnfilledDataMobTest extends MobBaseTest {
    private static HelloPageMob helloPageMob;
    private static LoginPageMob loginPage;


    @BeforeEach
    public void prepare() {
        configure();
        helloPageMob = new HelloPageMob();
        helloPageMob.verifyPageElements();

    }

    @Test
    public void loginWithEmptyUsername() {
        helloPageMob.clickLoginButton();

        loginPage = new LoginPageMob();
        loginPage.verifyPageElements();
        loginPage.login(null, "Password");

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String actualErrorMessage = loginPage.getErrorMessageText();
        String expectedErrorMessage = "Введите логин";
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }

    @Test
    public void loginWithEmptyPassword() {
        helloPageMob.clickLoginButton();

        loginPage = new LoginPageMob();
        loginPage.verifyPageElements();
        loginPage.login("userName", null);

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String actualErrorMessage = loginPage.getErrorMessageText();
        String expectedErrorMessage = "Введите пароль";
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");

    }
}

