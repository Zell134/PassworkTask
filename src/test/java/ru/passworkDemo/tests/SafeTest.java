package ru.passworkDemo.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.passworkDemo.pageObjects.AutorizationPage;
import ru.passworkDemo.pageObjects.MainPage;
import ru.passworkDemo.utils.PropertiesHelper;

import java.util.Random;

import static com.codeborne.selenide.Selenide.open;

public class SafeTest extends BaseTest{
    private MainPage mainPage;

    @BeforeEach
    public void openBrowser(){
        open(PropertiesHelper.getBaseUrl());
        mainPage = login();
    }

    @Test
    public void positiveSelfSafeCreationTest(){

        String expectedSafeName = "Safe_" + new Random().nextInt();

        mainPage
                .withControlsPanel()
                .isSafeNotPresentInSelfSafes(expectedSafeName)
                .addSelfSafe()
                .typeSafeName(expectedSafeName)
                .pressEnter()
                .withControlsPanel()
                .isSafeContainsInSelfSafes(expectedSafeName);

        deleteSelfSafeSafe(expectedSafeName);
        mainPage.logout();
    }

    @Test
    public void positiveOrganizationSafeCreationTest(){

        String expectedSafeName = "Safe_" + new Random().nextInt();

        mainPage
                .withControlsPanel()
                .isSafeNotPresentInOrganizationSafes(expectedSafeName)
                .addOrganizationSafe()
                .typeSafeName(expectedSafeName)
                .pressEnter()
                .withControlsPanel()
                .isSafeContainsInOrganizationSafes(expectedSafeName);

        deleteSelfOrganizationSafe(expectedSafeName);
        mainPage.logout();
    }

    private MainPage login(){
        String login = PropertiesHelper.getLogin();
        String password = PropertiesHelper.getPassword();
        return new AutorizationPage()
                .typeLogin(login)
                .typePassword(password)
                .pressEnter();
    }

    private void deleteSelfSafeSafe(String safeName){
        mainPage
                .withControlsPanel()
                .openOnSelfSafe(safeName)
                .deleteSafe()
                .withControlsPanel()
                .isSafeNotPresentInSelfSafes(safeName);
    }

    private void deleteSelfOrganizationSafe(String safeName){
        mainPage
                .withControlsPanel()
                .openOrganizationSafe(safeName)
                .deleteSafe()
                .withControlsPanel()
                .isSafeNotPresentInOrganizationSafes(safeName);
    }
}
