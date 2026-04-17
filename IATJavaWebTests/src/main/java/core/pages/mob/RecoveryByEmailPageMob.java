package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByEmailPageMob extends MobBasePage {

    public SelenideElement pageTitle = $(".title_text_main");
    public SelenideElement getCodeButton = $(byText("Получить код"));

}
