package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class AnonymRecoveryPage extends BasePage {
    private SelenideElement phoneRecoveryButton = $("[data-l=\"t,phone\"]");
    private SelenideElement emailRecoveryButton = $("[data-l=\"t,email\"]");
    private SelenideElement supportMessageButton = $(".support-link_items");

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
    public void goToSupportPage(){
        supportMessageButton.click();
    }



}
