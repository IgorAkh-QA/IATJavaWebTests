package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class LoginPageMob extends MobBasePage {

    SelenideElement userNameField = $("#field_email");
    SelenideElement passwordField = $("#field_password");
    SelenideElement loginButton = $(".vkuiButton__in").$(withText("Войти"));
    SelenideElement forgotPasswordLink = $("[aria-label=\"Не получается войти?\"]");
    SelenideElement errorMessage = $("[class^=LoginForm-module__error]");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов страницы")
    public void verifyPageElements() {
        userNameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
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
        //userNameField.click();
        userNameField.setValue(userName);
        passwordField.click();
        passwordField.setValue(password);
        loginButton.shouldBe(clickable).click();
    }

    @Step("Вводим имя пользователя")
    public void setUsername(String username){
        userNameField.setValue(username);
    }

    @Step("Вводим пароль")
    public void setPassword(String password) {
        passwordField.setValue(password);
    }

    @Step("Нажимаем на кнопку Войти")
    public void clickLoginButton(){
        loginButton.click();
    }

    @Step("Ввести некорректно пароль 3 раза")
    public void accessToPageWithCaptchaAppearsLogic() {
        login("wrongUserName141342", "12");
        for (int i = 0; i < 2; i++) {
            setPassword("1");
            clickLoginButton();
        }
    }



    @Step("Переходим на страницу восстановления пароля")
    public void openRecoveryStartPage() {
        forgotPasswordLink.click();
    }

    /*@Step("Переходим на страницу регистрации")
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
    }*/
}
