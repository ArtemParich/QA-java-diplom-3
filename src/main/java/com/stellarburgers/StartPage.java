package com.stellarburgers;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class StartPage {

    public static final String SITE_URL = "https://stellarburgers.nomoreparties.site";

    //локатор для ожидания открытия Стартовой страницы
    @FindBy(how = How.XPATH,using = ".//*[@class='BurgerIngredients_ingredients__1N8v2']//*[text() = \"Соберите бургер\"]")
    public SelenideElement waitOpenStartPage;
    //метод ожидания открытия Стартовой страницы
    @Step("Ожидаем открытие главной страницы")
    public void waitOpenStartPage() {
        waitOpenStartPage.shouldHave(Condition.text("Соберите бургер"));
    }

    // локатор для кнопки "Войти в аккаунт"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"App_componentContainer__2JC2W\"]//*[text()=\"Войти в аккаунт\"]")
    private SelenideElement signInAccountButton;
    // метод клика по кнопке "Войти в аккаунт"
    @Step("Нажимаем на кнопку 'Войти в аккаунт'")
    public void clickSignInAccountButton() {
        signInAccountButton.click();
    }

    // локатор для кнопки "Оформить заказ"
    @FindBy(how = How.XPATH, using = ".//*[@id=\"root\"]//button[text()=\"Оформить заказ\"]")
    public SelenideElement placeOrderButton;

    // локатор для ссылки "Личный кабинет"
    @FindBy(how = How.XPATH, using = ".//*[@href = '/account']")
    private SelenideElement accountProfileLink;
    // метод клика по ссылке "Личный кабинет"
    @Step("Нажимаем на ссылку 'Личный кабинет'")
    public void clickAccountProfileLink() {
        accountProfileLink.click();
    }

    // локатор для ссылки "Булки"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"BurgerIngredients_ingredients__1N8v2\"]//span[text()=\"Булки\"]/..")
    public SelenideElement bunsLink;
    // метод клика по ссылке "Булки"
    @Step("Нажимаем на ссылку 'Булки'")
    public void clickBunsLink() {
        bunsLink.click();
    }

    // локатор для ссылки "Соусы"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"BurgerIngredients_ingredients__1N8v2\"]//span[text()=\"Соусы\"]/..")
    public SelenideElement saucesLink;
    // метод клика по ссылке "Соусы"
    @Step("Нажимаем на ссылку 'Соусы'")
    public void clickSaucesLink() {
        saucesLink.click();
    }

    // локатор для ссылки "Начинки"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"BurgerIngredients_ingredients__1N8v2\"]//span[text()=\"Начинки\"]/..")
    public SelenideElement fillingsLink;
    // метод клика по ссылке "Начинки"
    @Step("Нажимаем на ссылку 'Начинки'")
    public void clickFillingsLink() {
        fillingsLink.click();
    }

}
