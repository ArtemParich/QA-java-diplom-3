package com.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //локатор для ожидания открытия страницы "Войти"
    @FindBy(how = How.XPATH,using = ".//*[@class=\"Auth_login__3hAey\"]//*[text()=\"Вход\"]")
    public SelenideElement waitOpenSignInPage;
    //метод ожидания открытия страницы Войти
    @Step("Ожидаем открытие страницы 'Войти'")
    public void waitOpenSignInPage () {
        waitOpenSignInPage.shouldHave(Condition.text("Вход"));
    }

    //локатор для поля ввода "Email"
    @FindBy(how = How.XPATH, using = "//label[text() = 'Email']/../input")
    private SelenideElement emailInputFiled;
    //метод очистки поля ввода Email
    //при запуске тестов в Яндекс Браузере, срабатывает автоподстановка текста после регистрации пользователя
    @Step("Очищаем поле ввода Email")
    public void clearEmailFiled () {
        emailInputFiled.sendKeys(Keys.COMMAND + "a"); //для MacOS, для Window изменить на Keys.CONTROL
        emailInputFiled.sendKeys(Keys.DELETE);
    }
    //метод ввода Email
    @Step("Вводим Email")
    public void setEmailInputFiled (String email) {
        emailInputFiled.setValue(email);
    }

    //локатор для поля ввода "Пароль"
    @FindBy(how = How.XPATH, using = "//label[text() = 'Пароль']/../input")
    private SelenideElement passwordInputFiled;
    //метод очистки поля ввода Пароль
    //при запуске тестов в Яндекс Браузере, срабатывает автоподстановка текста после регистрации пользователя
    @Step("Очищаем поле ввода Пароль")
    public void clearPasswordFiled () {
        passwordInputFiled.sendKeys(Keys.COMMAND + "a"); //для MacOS, для Window изменить на Keys.CONTROL
        passwordInputFiled.sendKeys(Keys.DELETE);
    }
    //метод ввода Пароля
    @Step("Вводим Пароль")
    public void setPasswordInputFiled (String password) {
        passwordInputFiled.setValue(password);
    }

    // локатор для кнопки "Войти"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"Auth_form__3qKeq mb-20\"]/button[text()=\"Войти\"]")
    private SelenideElement signInButton;
    // метод клика по кнопке "Войти"
    @Step("Нажимаем на кнопку 'Войти'")
    public void clickSignInButton() {
        signInButton.click();
    }

    // локатор для ссылки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//*[@href = '/register']")
    private SelenideElement signUpLink;
    // метод клика по ссылке "Зарегистрироваться"
    @Step("Нажимаем на ссылку 'Зарегистрироваться'")
    public void clickSignUpLink() {
        signUpLink.click();
    }

    // локатор для ссылки "Восстановить пароль"
    @FindBy(how = How.XPATH, using = ".//*[@href = '/forgot-password']")
    private SelenideElement forgotPasswordLink;
    // метод клика по ссылке "Восстановить пароль"
    @Step("Нажимаем на ссылку 'Восстановить пароль'")
    public void clickForgotPasswordLink() {
        forgotPasswordLink.click();
    }


}
