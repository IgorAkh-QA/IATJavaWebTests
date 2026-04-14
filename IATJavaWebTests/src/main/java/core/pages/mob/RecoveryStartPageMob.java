package core.pages.mob;

import com.codeborne.selenide.ClickOptions;
import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

import org.junit.jupiter.api.Assertions;


public class RecoveryStartPageMob extends MobBasePage {
    public SelenideElement pageTitle = $(".tittle_text_main='Восстановление доступа'");
    private SelenideElement phoneRecoveryButton = $("[href*=newRecoveryStartPhoneLink");
    private SelenideElement emailRecoveryButton = $("[href*=newRecoveryStartEmailLink");

    @Step("Нажимаем на кнопку восстановления доступа к аккаунта через номер телефона")
    public void goToPhoneRecovery() {
        phoneRecoveryButton.click();
    }

    @Step("Нажимаем на кнопку восстановления доступа к аккаунта через email")
    public void goToEmailRecovery() {
        emailRecoveryButton.click();
    }

}
