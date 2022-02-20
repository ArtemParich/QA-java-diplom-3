package com.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

public class SignInTest {

    StartPage startPage;
    LoginPage loginPage;
    UserOperations userOperations;
    Map<String, String> responseData;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "driver/yandexdriver"); //снять комментарий, для запуска тестов в YandexBrowser
        Configuration.startMaximized = true; //браузер во все окно
        startPage = open(StartPage.SITE_URL, StartPage.class);
        loginPage = page(LoginPage.class);
        userOperations = new UserOperations();
        responseData = userOperations.register();
        startPage.waitOpenStartPage();
    }

    @Test
    public void canSignInUsingButtonSignInAccountTest() {

        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();

        assertTrue("Должна быть видна кнопка 'Оформить заказ'", startPage.placeOrderButton.shouldBe(Condition.visible).isDisplayed());
    }

    @Test
    public void canSignInUsingLinkPersonalAccountTest() {

        startPage.clickAccountProfileLink();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();

        assertTrue("Должна быть видна кнопка 'Оформить заказ'", startPage.placeOrderButton.shouldBe(Condition.visible).isDisplayed());
    }

    @Test
    public void canSignInUsingLinkSignInInRegistrationPageTest() {

        RegisterPage registerPage = page(RegisterPage.class);

        startPage.clickAccountProfileLink();
        loginPage.waitOpenSignInPage();
        loginPage.clickSignUpLink();
        registerPage.waitOpenSignUpPage();
        registerPage.clickSignInLink();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();

        assertTrue("Должна быть видна кнопка 'Оформить заказ'", startPage.placeOrderButton.shouldBe(Condition.visible).isDisplayed());
    }

    @Test
    public void canSignInUsingLinkSignInInForgotPasswordPageTest() {

        ForgotPasswordPage forgotPasswordPage = page(ForgotPasswordPage.class);

        startPage.clickAccountProfileLink();
        loginPage.waitOpenSignInPage();
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.waitOpenForgotPasswordPage();
        forgotPasswordPage.clickSignInLink();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();

        assertTrue("Должна быть видна кнопка 'Оформить заказ'", startPage.placeOrderButton.shouldBe(Condition.visible).isDisplayed());
    }

    @After
    public void finish() {
        userOperations.delete();
        webdriver().driver().close();
    }
}
