package cloud.autotests.tests;


import cloud.autotests.pages.CartPage;
import cloud.autotests.pages.CatalogPage;
import cloud.autotests.pages.MainPage;
import cloud.autotests.pages.components.HeaderNavigationComponent;
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
    HeaderNavigationComponent headerNavigationComponent = new HeaderNavigationComponent();
    CatalogPage catalogPage = new CatalogPage();
    CartPage cartPage = new CartPage();

    private String catalogCategory = "Мясо, птица, колбаса";
    private String productName = "Колбаса";

    @Test
    @DisplayName("Отображение кнопок разделов на главной странице сайта")
    @Severity(value = SeverityLevel.CRITICAL)
    public void menuItemsDisplayedOnTheMainPage() {
        mainPage
                .openPage();
        headerNavigationComponent
                .checkThatNavigationButtonsAreDisplayed();
    }

    @Test
    @DisplayName("Переход в категорию каталога")
    @Severity(value = SeverityLevel.CRITICAL)
    public void goToCatalogGroup() {
        mainPage.
                openPage();
        headerNavigationComponent
                .goToCatalog();
        catalogPage
                .goToCatalogCategory(catalogCategory)
                .checkCatalogCategoryHeaderText(catalogCategory);

    }

    @Test
    @DisplayName("Поиск по наименованию продукта")
    @Severity(value = SeverityLevel.CRITICAL)
    public void searchItemInCatalog() {
        mainPage
                .openPage();
        headerNavigationComponent
                .searchByValue(productName);
        catalogPage
                .checkProductValueName(productName)
                .checkCatalogSearchResultsHeader(productName);
    }

    @Test
    @DisplayName("Отображение соответствующих подсказок при поиске")
    @Severity(value = SeverityLevel.MINOR)
    public void checkSearchSuggestions() {
        mainPage
                .openPage();
        headerNavigationComponent
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
        headerNavigationComponent
                .goToCatalog();
        catalogPage
                .goToCatalogCategory(catalogCategory)
                .addProductToCart();
        headerNavigationComponent
                .checkNumberDisplayedNextToCart("1")
                .goToCart();
        cartPage
                .checkThatThereAreProductsInCart()
                .checkNumberOfProductsInCart("1");

    }

}
