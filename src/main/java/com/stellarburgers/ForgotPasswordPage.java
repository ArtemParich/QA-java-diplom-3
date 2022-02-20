package com.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ForgotPasswordPage {
    //локатор для ожидания открытия страницы "Восстановление пароля"
    @FindBy(how = How.XPATH,using = ".//*[@class=\"Auth_login__3hAey\"]//*[text()=\"Восстановление пароля\"]")
    private SelenideElement waitOpenForgotPasswordPage;
    //метод ожидания открытия страницы Восстановление пароля
    @Step("Ожидаем открытие страницы 'Восстановление пароля'")
    public void waitOpenForgotPasswordPage () {
        waitOpenForgotPasswordPage.shouldHave(Condition.text("Восстановление пароля"));
    }

    // локатор для ссылки "Войти"
    @FindBy(how = How.XPATH, using = ".//*[@href = '/login']")
    private SelenideElement signInLink;
    // метод клика по ссылке "Войти"
    @Step("Нажимаем на ссылку 'Войти'")
    public void clickSignInLink() {
        signInLink.click();
    }
}
