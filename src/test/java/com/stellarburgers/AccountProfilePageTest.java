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

public class AccountProfilePageTest {

    StartPage startPage;
    LoginPage loginPage;
    AccountProfilePage accountProfilePage;
    UserOperations userOperations;
    Map<String, String> responseData;

    @Before
    public void start() {
        System.setProperty("webdriver.chrome.driver", "driver/yandexdriver");
        Configuration.startMaximized = true; //браузер во все окно
        startPage = open(StartPage.SITE_URL, StartPage.class);
        loginPage = page(LoginPage.class);
        accountProfilePage = page(AccountProfilePage.class);
        userOperations = new UserOperations();
        responseData = userOperations.register();
    }

    @Test
    public void canSignInUsingButtonSignInAccountTest() {

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();
        startPage.clickAccountProfileLink();
        accountProfilePage.waitOpenAccountProfilePage();

        assertTrue("Должен быть виден текст 'В этом разделе вы можете изменить свои персональные данные'", accountProfilePage.waitOpenAccountProfilePage.shouldBe(Condition.visible).isDisplayed());
    }

    @After
    public void finish() {
        userOperations.delete();
        webdriver().driver().close();
    }
}

