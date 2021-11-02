package cloud.autotests.tests;


import cloud.autotests.pages.Cart;
import cloud.autotests.pages.Catalog;
import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.components.HeaderNavigation;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Тесты для сайта lenta.com")
@Owner("Дарья Обедкина")
public class LentaUiTests extends TestBase {
    MainPage mainPage = new MainPage();
    HeaderNavigation headerNavigation = new HeaderNavigation();
    Catalog catalog = new Catalog();
    Cart cart = new Cart();

    private String catalogCategory = "Мясо, птица, колбаса";
    private String productName = "Колбаса";

    @Test
    @DisplayName("Отображение кнопок разделов на главной странице сайта")
    @Severity(value = SeverityLevel.CRITICAL)
    public void menuItemsDisplayedOnTheMainPage() {
        mainPage
                .openPage();
        headerNavigation
                .checkThatNavigationButtonsAreDisplayed();
    }

    @Test
    @DisplayName("Переход в категорию каталога")
    @Severity(value = SeverityLevel.CRITICAL)
    public void goToCatalogGroup() {
        mainPage.
                openPage();
        headerNavigation
                .goToCatalog();
        catalog
                .goTocatalogCategory(catalogCategory)
                .checkCatalogCategoryHeaderText(catalogCategory);

    }

    @Test
    @DisplayName("Поиск по наименованию продукта")
    @Severity(value = SeverityLevel.CRITICAL)
    public void searchItemInCatalog() {
        mainPage
                .openPage();
        headerNavigation
                .searchByValue(productName);
        catalog
                .checkProductValueName(productName)
                .checkCatalogSearchResultsHeader(productName);
    }

    @Test
    @DisplayName("Отображение соответствующих подсказок при поиске")
    @Severity(value = SeverityLevel.MINOR)
    public void checkSearchSuggestions() {
        mainPage
                .openPage();
        headerNavigation
                .setSearchValue(productName)
                .checkIfSuggestionsAreDisplayed()
                .checkFirstSuggestionText(productName);

    }

    @Test
    @DisplayName("Добавление одного товара в корзину")
    @Severity(value = SeverityLevel.BLOCKER)
    public void addOneProductToCart() {
        mainPage
                .openPage();
        headerNavigation
                .goToCatalog();
        catalog
                .goTocatalogCategory(catalogCategory)
                .addProductToCart();
        headerNavigation
                .checkNumberDisplayedNextToCart("1")
                .goToCart();
        cart
                .checkThatThereAreProductsInCart()
                .checkNumberOfProductsInCart("1");

    }

}
