package cloud.autotests.tests;


import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


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

    @Test
    public void searchItemInCatalog() {
        open("");
        $(".catalog-search__field").setValue("Колбаса");
        sleep(3000);
        $(".catalog-search__icon-label").click();
        $(".sku-card-small-container").shouldHave(Condition.text("Колбаса"));
    }

    @Test
    public void checkSearchSuggestions() {
        open("");
        $(".catalog-search__field").setValue("Колбаса");
        $(".spinner-lock").shouldBe(Condition.visible);
        $(".catalog-search__suggestions a").shouldHave(Condition.text("Колбаса"));
    }

    @Test
    public void addOneProductToCart() {
        open("");
        $(".header__catalog").click();
        $(".group-card").$(byText("Мясо, птица, колбаса")).click();
        $(".sku-card-small-basket-control__default-control").click();
        $(".sku-card-small-basket-control__input").shouldNotBe(Condition.value("0"));
        $(".header-catalog-link__counter--show").shouldHave(Condition.text("1"), Duration.ofSeconds(5));
        $(".header-catalog-link__icon").click();
        $(".sku-list-in-basket").shouldBe(Condition.visible);
        $(byText("Товаров в корзине")).sibling(0).shouldHave(Condition.text("1"));

    }

}
