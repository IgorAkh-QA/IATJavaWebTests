package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.WebBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;

public class LoginPageWeb extends WebBasePage {

    SelenideElement userNameField = $("#field_email");
    SelenideElement passwordField = $("#field_password");
    SelenideElement loginButton = $(".vkuiButton__in").$(withText("Войти"));
    SelenideElement loginByQrCodeButton = $(byText("Войти по QR-коду"));
    SelenideElement forgotPasswordLink = $("[aria-label=\"Не получается войти?\"]");
    SelenideElement registrationButton = $(".vkuiButton__in");
    SelenideElement vkButton = $(".__vk_id ");
    SelenideElement mailRuButton = $(".__mailru");
    SelenideElement yandexButton = $(".__yandex");
    SelenideElement errorMessage = $(".LoginForm-module__error___1xmAD");
    SelenideElement goToRecoveryButton = $("a[href*='anonymRecoveryStart']");
    SelenideElement captchaIframe = $("iframe[src*='not_robot_captcha']");
    SelenideElement qrCodeImage = $(".qr_code_image_wrapper");
    SelenideElement cantSignInButton = $(byText("Не получается войти?"));
    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов страницы")
    public void verifyPageElements() {
        userNameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        loginByQrCodeButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailRuButton.shouldBe(visible);
        yandexButton.shouldBe(visible);
    }

    @Step("Проверка видимости QR-code")
    public boolean isQrCodeVisible(){
        return qrCodeImage.shouldBe(visible).exists();
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

    @Step("Нажимаем на кнопку Войти по QR-коду")
    public void clickQrCodeLoginButton(){loginByQrCodeButton.click();}

    @Step("Нажимаем кнопку Не получается войти")
    public void clickCantSignInButton(){cantSignInButton.click();}

    @Step("Нажимаем на кнопку Восстановить")
    public void clickToRecoveryButton(){
        goToRecoveryButton.shouldBe(visible).click();
    }

    @Step("Ввести некорректно пароль 3 раза")
    public void accessToPageWithCaptchaAppearsLogic() {
        login("wrongUserName141342", "12");
        sleep(5000);

        if (captchaIframe.exists()) {
            switchTo().frame(captchaIframe);

            $(".vkc__ModalCardBase-module__container").shouldBe(visible);
            switchTo().defaultContent();
            open("https://ok.ru/dk?st.cmd=anonymRecoveryStart");
            return;
        }

        for (int i = 0; i < 2; i++) {
            setPassword("1");
            clickLoginButton();

            }
        clickToRecoveryButton();
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
