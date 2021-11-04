package cloud.autotests.pages.components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class HeaderNavigationComponent {
    @Step("На странице отображаются кнопки навигации")
    public HeaderNavigationComponent checkThatNavigationButtonsAreDisplayed() {
        $(".main-nav__inner").shouldHave(Condition.and("Items", Condition.text("Доставка"),
                Condition.text("О компании"), Condition.text("Магазины"), Condition.text("Акции"),
                Condition.text("Работа в ленте"), Condition.text("Электронные каталоги"), Condition.text("Рецепты")));
        return this;
    }

    @Step("Перейти в каталог")
    public HeaderNavigationComponent goToCatalog() {
        $(".header__catalog").click();
        return this;
    }

    @Step("Ввод значения {product} в строку поиска")
    public HeaderNavigationComponent setSearchValue(String product) {
        $(".catalog-search__field").setValue(product);
        return this;
    }

    @Step("Поиск по значению {product}")
    public HeaderNavigationComponent searchByValue(String product) {
        $(".catalog-search__field").setValue(product);
        sleep(3000);
        $(".catalog-search__icon-label").click();
        return this;
    }

    @Step("Под полем поиска отображаются подсказки")
    public HeaderNavigationComponent checkIfSuggestionsAreDisplayed() {
        $(".spinner-lock").shouldBe(Condition.visible);
        return this;
    }

    @Step("Первая в списке подсказка соответствует значению {product}")
    public HeaderNavigationComponent checkFirstSuggestionText(String product) {
        $(".catalog-search__suggestions a").shouldHave(Condition.text(product));
        return this;
    }

    @Step("Рядом с иконкой корзины отображается цифра {number}")
    public HeaderNavigationComponent checkNumberDisplayedNextToCart(String number) {
        $(".header-catalog-link__counter--show").shouldHave(Condition.text(number), Duration.ofSeconds(10));
        return this;
    }

    @Step("Перети в корзину")
    public HeaderNavigationComponent goToCart() {
        $(".header-catalog-link__icon").click();
        return this;
    }

}
