package com.stellarburgers;

import com.UserOperations;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

public class ConstructorPageTest {

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
    }

    @Test
    public void canOpenConstructorPageIfClickConstructorLinkTest() {
        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();
        startPage.clickAccountProfileLink();
        accountProfilePage.waitOpenAccountProfilePage();
        accountProfilePage.clickConstructorLink();
        startPage.waitOpenStartPage();

        assertTrue("Должна быть виден текст 'Соберите бургер'",
                startPage.waitOpenStartPage.shouldBe(Condition.visible).isDisplayed());
    }

    @Test
    public void canOpenConstructorPageIfClickLogoTest() {
        AccountProfilePage accountProfilePage = page(AccountProfilePage.class);

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();
        startPage.clickAccountProfileLink();
        accountProfilePage.waitOpenAccountProfilePage();
        accountProfilePage.clickLogo();
        startPage.waitOpenStartPage();

        assertTrue("Должен быть виден текст 'Соберите бургер'",
                startPage.waitOpenStartPage.shouldBe(Condition.visible).isDisplayed());
    }

    @Test
    public void canOpenSectionBunsTest() {

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();
        startPage.clickFillingsLink();
        startPage.clickBunsLink();

        String expectedColor = "rgba(255, 255, 255, 1)";
        String expectedActiveNameClass  = "tab_tab_type_current__2BEPc";
        assertTrue("Цвет текста активной вкладки должен быть: " + expectedColor,
                startPage.bunsLink.shouldHave(Condition.cssValue("color", expectedColor)).isDisplayed());
        assertTrue("Название класса вкладки должно содержать: " + expectedActiveNameClass,
                startPage.bunsLink.getAttribute("class").contains(expectedActiveNameClass));
    }

    @Test
    public void canOpenSectionSaucesTest() {

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();
        startPage.clickSaucesLink();

        String expectedColor = "rgba(255, 255, 255, 1)";
        String expectedActiveNameClass  = "tab_tab_type_current__2BEPc";
        assertTrue("Цвет текста активной вкладки должен быть: " + expectedColor,
                startPage.saucesLink.shouldHave(Condition.cssValue("color", expectedColor)).isDisplayed());
        assertTrue("Название класса вкладки должно содержать: " + expectedActiveNameClass,
                startPage.saucesLink.getAttribute("class").contains(expectedActiveNameClass));
    }

    @Test
    public void canOpenSectionFillingsTest() {

        startPage.waitOpenStartPage();
        startPage.clickSignInAccountButton();
        loginPage.waitOpenSignInPage();
        loginPage.setEmailInputFiled(responseData.get("email"));
        loginPage.setPasswordInputFiled(responseData.get("password"));
        loginPage.clickSignInButton();
        startPage.waitOpenStartPage();
        startPage.clickFillingsLink();

        String expectedColor = "rgba(255, 255, 255, 1)";
        String expectedActiveNameClass  = "tab_tab_type_current__2BEPc";
        assertTrue("Цвет текста активной вкладки должен быть: " + expectedColor,
                startPage.fillingsLink.shouldHave(Condition.cssValue("color", expectedColor)).isDisplayed());
        assertTrue("Название класса вкладки должно содержать: " + expectedActiveNameClass,
                startPage.fillingsLink.getAttribute("class").contains(expectedActiveNameClass));
    }

    @After
    public void finish() {
        userOperations.delete();
        webdriver().driver().close();
    }
}
