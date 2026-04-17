package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.MobBasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HelloPageMob extends MobBasePage {


    SelenideElement loginButton = $("[name=loginButton]");
    SelenideElement signInButton = $("[name=registerButton]");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость элементов страницы")
    public void verifyPageElements() {
        loginButton.shouldBe(visible);
        signInButton.shouldBe(visible);
    }


    @Step("Нажимаем на кнопку Войти")
    public void clickLoginButton(){
        loginButton.shouldBe(clickable).click();
    }

    @Step("Нажимаем на кнопку Зарегистрироваться")
    public void clickSignInButton(){
        signInButton.click();
    }
}
