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

public class LogOutTest {

    UserOperations userOperations;
    StartPage startPage;
    LoginPage loginPage;
    AccountProfilePage accountProfilePage;
    Map<String, String> responseData;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "driver/yandexdriver"); //снять комментарий, для запуска тестов в YandexBrowser
        Configuration.startMaximized = true; //браузер во все окно
        userOperations = new UserOperations();
        startPage = open(StartPage.SITE_URL, StartPage.class);
        loginPage = page(LoginPage.class);
        accountProfilePage = page(AccountProfilePage.class);
        responseData = userOperations.register();
    }

    @Test
    public void canLogOutTest() {

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();
        startPage.clickAccountProfileLink();
        accountProfilePage.waitOpenAccountProfilePage();
        accountProfilePage.clickLogOutButton();
        loginPage.waitOpenSignInPage();

        assertTrue("Должен быть виден текст 'Вход'", loginPage.waitOpenSignInPage.shouldBe(Condition.visible).isDisplayed());
    }

    @After
    public void finish() {
        userOperations.delete();
        webdriver().driver().close();
    }
}

