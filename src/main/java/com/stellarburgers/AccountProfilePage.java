package com.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AccountProfilePage {
    //локатор для ожидания открытия страницы "Личный кабинет"
    @FindBy(how = How.XPATH,using = ".//*[@class = \"Account_nav__Lgali\"]//*[text()=\"В этом разделе вы можете изменить свои персональные данные\"]")
    public SelenideElement waitOpenAccountProfilePage;
    //метод ожидания открытия страницы Личный кабинет
    @Step("Ожидаем открытие страницы 'Личный кабинет'")
    public void waitOpenAccountProfilePage () {
        waitOpenAccountProfilePage.shouldHave(Condition.text("В этом разделе вы можете изменить свои персональные данные"));
    }

    // локатор для ссылки "Конструктор"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"AppHeader_header__list__3oKJj\"]//*[text()=\"Конструктор\"]")
    private SelenideElement constructorLink;
    // метод клика по ссылке "Конструктор"
    @Step("Нажимаем на ссылку 'Конструктор'")
    public void clickConstructorLink() {
        constructorLink.click();
    }

    // локатор для логотипа "Stellar Burgers"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"AppHeader_header__logo__2D0X2\"]//*[@href=\"/\"]")
    private SelenideElement logo;
    // метод клика по логотипу "Stellar Burgers"
    @Step("Нажимаем на логотип 'Stellar Burgers'")
    public void clickLogo() {
        logo.click();
    }

    // локатор для кнопки "Выйти"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"Account_listItem__35dAP\"]/button[text()=\"Выход\"]")
    private SelenideElement logOutButton;
    // метод клика по кнопке "Выйти"
    @Step("Нажимаем на кнопку 'Выйти'")
    public void clickLogOutButton() {
        logOutButton.click();
    }
}
