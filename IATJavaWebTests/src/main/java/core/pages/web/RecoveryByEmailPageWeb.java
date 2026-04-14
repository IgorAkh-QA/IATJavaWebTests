package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.WebBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class RecoveryByEmailPageWeb extends WebBasePage {

    private SelenideElement pageTitle = $(".ext-registration_h");
    private SelenideElement emailInput = $("#field_email");
    private SelenideElement getCodeButton = $("input[type='submit'][value='Получить код']");




    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов на странице восстановления пароля")
    public void verifyPageElements(){
        pageTitle.shouldBe(visible).shouldHave(text("Почта"));
        emailInput.shouldBe(visible);
        getCodeButton.shouldBe(visible);

    }
    @Step("Нажимаем на кнопку Получить код")
    public void getCodeButtonlick(){
        getCodeButton.click();
    }

}
