package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    @Step("Перейти в категорию каталога {category}")
    public CatalogPage goToCatalogCategory(String category) {
        $(".group-card").$(byText(category)).click();
        return this;
    }

    @Step("Проверить заголовок категории каталога {category}")
    public CatalogPage checkCatalogCategoryHeaderText(String category) {
        $(".catalog-view__title").shouldHave(Condition.text(category));
        return this;
    }

    @Step("Название товара содержит слово {product}")
    public CatalogPage checkProductValueName(String product) {
        $(".sku-card-small-container").shouldHave(Condition.text(product));
        return this;
    }

    @Step("Отображение заголовка для результатов поиск по значению {product}")
    public CatalogPage checkCatalogSearchResultsHeader(String product) {
        $(".search-results-page__title")
                .shouldHave(Condition.text(String.format("Результаты поиска: «%s»", product)));
        return this;
    }

    @Step("Добавить продукт в корзину")
    public CatalogPage addProductToCart() {
        $(".sku-card-small-basket-control__default-control").click();
        return this;
    }

}
