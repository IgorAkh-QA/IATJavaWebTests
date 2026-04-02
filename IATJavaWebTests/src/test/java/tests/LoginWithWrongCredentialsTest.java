package tests;

import core.base.BaseTest;
import core.pages.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithWrongCredentialsTest extends BaseTest {
    private static LoginPage loginPage;


    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void loginAttemptWithWrongCredentialsShowsError() {
        loginPage.login("incorrectUser", "incorrectPassword");

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String actualErrorMessage = loginPage.getErrorMessageText();
        String expectedErrorMessage = "Неправильно указан логин и/или пароль";
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");
    }

    @Test
    public void loginAttemptWithoutPasswordShowsError() {
        loginPage.login("user", null);

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String actualErrorMessage = loginPage.getErrorMessageText();
        String expectedErrorMessage = "Введите пароль";
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");

    }

    @Test
    public void loginAttemptWithoutUserNameShowsError() {
        loginPage.login(null, "password");

        assertTrue(loginPage.isErrorMessageVisible(), "Сообщение об ошибке входа не отображается");

        String actualErrorMessage = loginPage.getErrorMessageText();
        String expectedErrorMessage = "Введите логин";
        assertEquals(expectedErrorMessage, actualErrorMessage, "Текст сообщения об ошибке не совпадает с ожидаемым");

    }
}

