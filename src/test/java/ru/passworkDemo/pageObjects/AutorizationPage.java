package ru.passworkDemo.pageObjects;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

    public class AutorizationPage {
    private SelenideElement login = $(By.id("email-input_login"));
    private SelenideElement password = $(By.id("password-input_login"));

    public AutorizationPage typeLogin(String value){
        login.should(Condition.visible).sendKeys(value);
        return this;
    }

    public AutorizationPage typePassword(String value){
        password.should(Condition.visible).sendKeys(value);
        return this;
    }

    public MainPage pressEnter(){
        password.should(Condition.visible).pressEnter();

        //required to close banner
        Selenide.actions().pause(2000).build().perform();
        SelenideElement closePlayerBtn = $(By.xpath("//button[contains(@class,'video-player__close')]"));
        if(closePlayerBtn.isDisplayed()){
            closePlayerBtn.click();
        }

        return new MainPage();
    }
}
