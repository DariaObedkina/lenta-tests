package cloud.autotests.pages.components;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class HeaderNavigation {
    @Step("На странице отображаются кнопки навигации")
    public HeaderNavigation checkThatNavigationButtonsAreDisplayed() {
        $(".main-nav__inner").shouldHave(Condition.and("Items", Condition.text("Доставка"),
                Condition.text("О компании"), Condition.text("Магазины"), Condition.text("Акции"),
                Condition.text("Работа в ленте"), Condition.text("Электронные каталоги"), Condition.text("Рецепты")));
        return this;
    }
}
