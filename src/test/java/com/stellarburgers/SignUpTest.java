package com.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class SignUpTest {

    StartPage startPage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "driver/yandexdriver"); //снять комментарий, для запуска тестов в YandexBrowser
        Configuration.startMaximized = true; //браузер во все окно
        startPage = open(StartPage.SITE_URL, StartPage.class);
        loginPage = page(LoginPage.class);
        registerPage = page(RegisterPage.class);
    }

    @Test
    public void canRegisterUserTest() throws InterruptedException {
        String email = RandomStringUtils.randomAlphabetic(10) + "@yandex.ru";
        String password = RandomStringUtils.randomAlphabetic(10);
        String name = RandomStringUtils.randomAlphabetic(10);
        UserOperations userOperations = new UserOperations();

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.clickSignUpLink();
        registerPage.waitOpenSignUpPage();
        registerPage.setNameInputFiled(name);
        registerPage.setEmailInputFiled(email);
        registerPage.setPasswordInputFiled(password);
        registerPage.clickSignUpButton();
        loginPage.waitOpenSignInPage();
        Thread.sleep(3000);
        loginPage.clearEmailFiled();
        loginPage.setEmailInputFiled(email);
        loginPage.clearPasswordFiled();
        loginPage.setPasswordInputFiled(password);
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();

        assertTrue("Должна быть видна кнопка 'Оформить заказ'", startPage.placeOrderButton.shouldBe(Condition.visible).isDisplayed());
        userOperations.login(email, password);
        userOperations.delete();
    }

    @Test
    public void checkingErrorIfPasswordLessThanSixSymbol() {
        String password = "12345";

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.clickSignUpLink();
        registerPage.waitOpenSignUpPage();
        registerPage.setPasswordInputFiled(password);
        registerPage.clickSignUpButton();

        assertTrue("Должно быть видно уведомление 'Некорректный пароль'", registerPage.checkErrorPassword.shouldBe(Condition.visible).isDisplayed());
    }

    @After
    public void finish() {
        webdriver().driver().close();
    }
}
