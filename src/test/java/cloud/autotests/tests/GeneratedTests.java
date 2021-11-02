package cloud.autotests.tests;


import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.components.HeaderNavigation;
import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


public class GeneratedTests extends TestBase {
    MainPage mainPage = new MainPage();
    HeaderNavigation headerNavigation = new HeaderNavigation();

    @Test
    @DisplayName("На главной странице сайта отображаются кнопки перехода к разделам")
    public void menuItemsDisplayedOnTheMainPage() {
        mainPage
                .openPage();
        headerNavigation
                .checkThatNavigationButtonsAreDisplayed();
    }

    @Test
    public void goToCatalogGroup() {
        mainPage.openPage();
        $(".header__catalog").click();
        $(".group-card").$(byText("Мясо, птица, колбаса")).click();
        $(".catalog-view__title").shouldHave(Condition.text("Мясо, птица, колбаса"));
    }

    @Test
    public void searchItemInCatalog() {
        mainPage.openPage();
        $(".catalog-search__field").setValue("Колбаса");
        sleep(3000);
        $(".catalog-search__icon-label").click();
        $(".sku-card-small-container").shouldHave(Condition.text("Колбаса"));
    }

    @Test
    public void checkSearchSuggestions() {
        mainPage.openPage();
        $(".catalog-search__field").setValue("Колбаса");
        $(".spinner-lock").shouldBe(Condition.visible);
        $(".catalog-search__suggestions a").shouldHave(Condition.text("Колбаса"));
    }

    @Test
    public void addOneProductToCart() {
        mainPage.openPage();
        $(".header__catalog").click();
        $(".group-card").$(byText("Мясо, птица, колбаса")).click();
        $(".sku-card-small-basket-control__default-control").click();
        $(".header-catalog-link__counter--show").shouldHave(Condition.text("1"), Duration.ofSeconds(10));
        $(".header-catalog-link__icon").click();
        $(".sku-list-in-basket").shouldBe(Condition.visible);
        $(byText("Товаров в корзине")).sibling(0).shouldHave(Condition.text("1"));

    }

}
