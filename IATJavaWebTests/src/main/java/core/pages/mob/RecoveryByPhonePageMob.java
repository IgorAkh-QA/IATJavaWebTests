package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByPhonePageMob extends MobBasePage {

    public SelenideElement pageSubTitle = $(".block");
    public SelenideElement getCodeButton = $(byText("Получить код"));

}
