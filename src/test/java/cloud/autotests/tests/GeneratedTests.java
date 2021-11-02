package cloud.autotests.tests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GeneratedTests extends TestBase {
    @Test
    public void menuItemsDisplayedOnTheMainPage() {
        open("");
        $(".main-nav__inner").shouldHave(Condition.and("Items", Condition.text("Доставка"),
                Condition.text("О компании"), Condition.text("Магазины"), Condition.text("Акции"),
                Condition.text("Работа в ленте"), Condition.text("Электронные каталоги"), Condition.text("Рецепты")));
    }

    @Test
    public void goToCatalogGroup() {
        open("");
        $(".header__catalog").click();
        $(".group-card").$(byText("Мясо, птица, колбаса")).click();
        $(".catalog-view__title").shouldHave(Condition.text("Мясо, птица, колбаса"));
    }

}
