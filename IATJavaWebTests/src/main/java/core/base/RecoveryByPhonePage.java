package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class RecoveryByPhonePage extends BasePage {
    private SelenideElement pageTitle = $(".ext-registration_h");

    private SelenideElement titleForPhoneNumberInput = $("label[for=field_phone]");
    private SelenideElement phoneNumberInput = $("#field_phone");

    private SelenideElement titleForCountryDropdownSelector = $("label[for=country]");
    private SelenideElement countryDropdownSelector = $(".country-select_label");

    private SelenideElement getCodeButton = $("input[type=submit][value='Получить код']");

    private SelenideElement errorPhoneMessage = $(".input-e");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов на странице восстановления пароля")
    public void verifyPageElements() {
        pageTitle.shouldBe(visible).shouldHave(text("Укажите телефон"));
        titleForPhoneNumberInput.shouldBe(visible);
        phoneNumberInput.shouldBe(visible);
        titleForCountryDropdownSelector.shouldBe(visible);
        countryDropdownSelector.shouldBe(visible);
        getCodeButton.shouldBe(visible);

    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryDropdownSelector.click();
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();
        countryItem.click();
        return countryCode;
    }

    @Step("Проверка отображения ошибки с корректным текстом")
    public String checkErrorAndErrorMessage() {
        getCodeButton.click();
        errorPhoneMessage.shouldBe(visible);
        return errorPhoneMessage.getText();

    }
}


