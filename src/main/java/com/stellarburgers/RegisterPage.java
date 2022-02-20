package com.stellarburgers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
    //локатор для ожидания открытия страницы "Регистрация"
    @FindBy(how = How.XPATH,using = ".//*[@class=\"Auth_login__3hAey\"]//*[text()=\"Регистрация\"]")
    private SelenideElement waitOpenSignUpPage;
    //метод ожидания открытия страницы Регистрации
    @Step("Ожидаем открытие страницы 'Регистрация'")
    public void waitOpenSignUpPage () {
        waitOpenSignUpPage.shouldHave(Condition.text("Регистрация"));
    }


    //локатор для поля ввода "Имя"
    @FindBy(how = How.XPATH, using = "//label[text() = 'Имя']/../input")
    private SelenideElement nameInputFiled;
    //метод ввода имени
    @Step("Вводим Имя")
    public void setNameInputFiled (String name) {
        nameInputFiled.setValue(name);
    }

    //локатор для поля ввода "Email"
    @FindBy(how = How.XPATH, using = "//label[text() = 'Email']/../input")
    private SelenideElement emailInputFiled;
    //метод ввода Email
    @Step("Вводим Email")
    public void setEmailInputFiled (String email) {
        emailInputFiled.setValue(email);
    }

    //локатор для поля ввода "Пароль"
    @FindBy(how = How.XPATH, using = "//label[text() = 'Пароль']/../input")
    private SelenideElement passwordInputFiled;
    //метод ввода Пароля
    @Step("Вводим Пароль")
    public void setPasswordInputFiled (String password) {
        passwordInputFiled.setValue(password);
    }

    // локатор для кнопки "Зарегистрироваться"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"Auth_form__3qKeq mb-20\"]/button[text()=\"Зарегистрироваться\"]")
    private SelenideElement signUpButton;
    // метод клика по кнопке "Зарегистрироваться"
    @Step("Нажимаем на кнопку 'Зарегистрироваться'")
    public void clickSignUpButton() {
        signUpButton.click();
    }

    // локатор для уведомления "Некорректный пароль"
    @FindBy(how = How.XPATH, using = ".//*[@class=\"input__container\"]//*[text()=\"Некорректный пароль\"]")
    public SelenideElement checkErrorPassword;

    // локатор для ссылки "Войти"
    @FindBy(how = How.XPATH, using = ".//*[@href = '/login']")
    private SelenideElement signInLink;
    // метод клика по ссылке "Войти"
    @Step("Нажимаем на ссылку 'Войти'")
    public void clickSignInLink() {
        signInLink.click();
    }
}
