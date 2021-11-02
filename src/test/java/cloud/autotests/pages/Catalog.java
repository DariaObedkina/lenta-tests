package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Catalog {
    @Step("Перейти в категорию каталога")
    public Catalog goTocatalogCategory(String category) {
        $(".group-card").$(byText("Мясо, птица, колбаса")).click();
        return this;
    }

    @Step("Проверить заголовок категории каталога")
    public Catalog checkCatalogCategoryHeaderText(String category) {
        $(".catalog-view__title").shouldHave(Condition.text("Мясо, птица, колбаса"));
        return this;
    }

    @Step("Название товара содержит слово {product}")
    public Catalog checkProductValueName(String product) {
        $(".sku-card-small-container").shouldHave(Condition.text(product));
        return this;
    }

    @Step("Отображение заголовка для результатов поиск по значению {}")
    public Catalog checkCatalogSearchResultsHeader(String product) {
        $(".search-results-page__title")
                .shouldHave(Condition.text(String.format("Результаты поиска: «%s»", product)));
        return this;
    }

    @Step("Добавить продукт в корзину")
    public Catalog addProductToCart() {
        $(".sku-card-small-basket-control__default-control").click();
        return this;
    }

}
