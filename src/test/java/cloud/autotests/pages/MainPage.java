package cloud.autotests.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    @Step("Открыть https://lenta.com/")
    public MainPage openPage() {
        open("");
        return this;
    }
}
