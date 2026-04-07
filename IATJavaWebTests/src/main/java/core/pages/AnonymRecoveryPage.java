package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class AnonymRecoveryPage extends BasePage {
    private SelenideElement phoneRecoveryButton = $("[data-l=\"t,phone\"]");
    private SelenideElement emailRecoveryButton = $("[data-l=\"t,email\"]");
    private SelenideElement supportMessageButton = $(".support-link_items");
    private SelenideElement supportChatWindow = $("support-chat");
    private SelenideElement exitSupportChatButton = supportChatWindow.$("[name^='ico_close']").closest("button");
    private SelenideElement confirmExitSupportChatWindowButton = supportChatWindow.$("button").$(withText("Да"));

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов на странице восстановления пароля")
    public void verifyPageElements(){
        phoneRecoveryButton.shouldBe(visible);
        emailRecoveryButton.shouldBe(visible);
        supportMessageButton.shouldBe(visible);

    }
    @Step("Нажимаем на кнопку восстановления доступа к аккаунта через номер телефона")
    public void goToPhoneRecovery(){
        phoneRecoveryButton.click();
    }

    @Step("Нажимаем на кнопку восстановления доступа к аккаунта через email")
    public void goToEmailRecovery(){
        emailRecoveryButton.click();
    }

    @Step("Нажимаем на кнопку перехода к обращения в техническую поддержку")
    public void clickSupportMessageButton(){
        supportMessageButton.click();
    }

    @Step("Проверяем, что окно чата технической поддержки отображается на странице")
    public boolean isSupportChatVisible(){
        return supportChatWindow.shouldBe(visible).exists();
    }

    @Step("Нажимаем на закрытие окна чата с поддержкой")
    public void clickExitSupportChatButton(){
        exitSupportChatButton.shouldBe(clickable).click();
    }

    @Step("Подтверждаем закрытие окна чата с поддержкой")
    public void clickConfirmExitSupportChatWindowButton(){
        confirmExitSupportChatWindowButton.shouldBe(interactable).click();
    }


}
