package core.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class AnonymHeaderPanelComponent {
    private SelenideElement headerSearchInput = $(".toolbar_search_input");
    private SelenideElement searchSuggests = $(".toolbar_search_suggests");
    public SelenideElement getSuggestElementByValue(String value){
        return $(".toolbar_search_suggests").$(byText(value));
    }

    {
        verifyComponentElements();
    }

    @Step("Проверяем видимость элементов компонента")
    public void verifyComponentElements(){
        headerSearchInput.shouldBe(visible);
    }

    //@Step("Получаем отображаемый в результатах предиктивного поиска текст")

    @Step("Вводим значение в инпут поиска в хедере")
    public void headerSearchInputSetValue(String value){
        headerSearchInput.setValue(value);
    }

    @Step("Проверяем отображение блока результатов предиктивного поиска")
    public void verifySearchSuggest(){
        searchSuggests.shouldBe(visible, Duration.ofSeconds(10));
    }

    @Step("Проверяем корректность отображаемого результата предиктивного поиска, значение элемента: {value}")
    public void verifySearchResults(String value){
        getSuggestElementByValue(value).shouldBe(visible);
    }
}

