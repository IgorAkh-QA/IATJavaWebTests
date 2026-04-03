package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;


public class RecoveryByPhonePage extends BasePage {
    private SelenideElement pageTitle = $(".ext-registration_h");

    private SelenideElement titleForPhoneNumberInput = $("label[for=field_phone]");
    private SelenideElement phoneNumberInput = $("#field_phone");

    private SelenideElement titleForCountryDropdownSelector = $("label[for=country]");
    private SelenideElement countryDropdownSelector = $(".country-select_label");

    private SelenideElement getCodeButton = $("input[type=submit][value='Получить код']");




    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов на странице восстановления пароля")
    public void verifyPageElements(){
        pageTitle.shouldBe(visible).shouldHave(text("Укажите телефон"));
        titleForPhoneNumberInput.shouldBe(visible);
        phoneNumberInput.shouldBe(visible);
        titleForCountryDropdownSelector.shouldBe(visible);
        countryDropdownSelector.shouldBe(visible);
        getCodeButton.shouldBe(visible);

    }
    @Step("Нажимаем на кнопку Получить код")
    public void getCodeButtonlick(){
        getCodeButton.click();
    }

}
