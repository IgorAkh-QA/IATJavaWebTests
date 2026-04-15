package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecoveryByPhonePageMob extends MobBasePage {

    public SelenideElement pageSubTitle = $(".block");
    public SelenideElement getCodeButton = $("#getCode");
    private SelenideElement errorMessage = $(".field_error-descr");
    private SelenideElement countryCodePlaceHolder = $("#field_phone_prefix");
    private SelenideElement countryList = $("#countryFlag");
    private SelenideElement countrySearchField = $("#searchListField");

    @Step("Выбираем страну по названию: {countryName}")
    public String getCountryCodeByName(String countryName){
        countryList.click();
        countrySearchField.shouldBe(visible).setValue(countryName).pressEnter();

        SelenideElement countryItem = $(byText(countryName));
        countryItem.shouldBe(visible).click();

        String countryCode = countryCodePlaceHolder.text();
        return countryCode;
    }

    @Step("Проверка отображения ошибки с корректным текстом")
    public String checkErrorAndErrorMessage() {
        getCodeButton.click();
        errorMessage.shouldBe(visible);
        return errorMessage.getText();
    }
}
