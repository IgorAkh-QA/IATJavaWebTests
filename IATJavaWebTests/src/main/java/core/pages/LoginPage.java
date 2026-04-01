package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class LoginPage extends BasePage {

    SelenideElement userNameField = $("#field_email");
    SelenideElement passwordField = $("#field_password");
    SelenideElement loginButton = $(".vkuiButton__in").$(withText("Войти"));
    SelenideElement forgotPasswordLink = $("[aria-label=\"Не получается войти?\"]");
    SelenideElement registrationButton = $(".vkuiButton__in");
    SelenideElement vkButton = $(".__vk_id ");
    SelenideElement mailRuButton = $(".__mailru");
    SelenideElement yandexButton = $(".__yandex");
    SelenideElement errorMessage = $(".LoginForm-module__error___1xmAD");


    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов страницы")
    public void verifyPageElements() {
        userNameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }

    @Step("Проверка видимости сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином: {userName} и паролем: {password}")
    public void login(String userName, String password) {
        userNameField.click();
        userNameField.setValue(userName);
        passwordField.click();
        passwordField.setValue(password);
        loginButton.click();
    }

    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPasswordPage() {
        forgotPasswordLink.click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistrationPage() {
        registrationButton.click();
    }

    @Step("Логинимся через VK")
    public void loginWithVk() {
        vkButton.click();
    }

    @Step("Логинимся через Mail.ru")
    public void loginWithMailRu() {
        mailRuButton.click();
    }

    @Step("Логинимся через yandex")
    public void loginWithYandex() {
        yandexButton.click();
    }
}
