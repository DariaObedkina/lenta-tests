package cloud.autotests.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Cart {
    @Step("В корзине есть товары")
    public Cart checkThatThereAreProductsInCart() {
        $(".sku-list-in-basket").shouldBe(Condition.visible);
        return this;
    }

    @Step("В корзине {number} продуктов")
    public Cart checkNumberOfProductsInCart(String number) {
        $(byText("Товаров в корзине")).sibling(0).shouldHave(Condition.text(number));
        return this;
    }

}