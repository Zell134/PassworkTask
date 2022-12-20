package ru.passworkDemo.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SafeAddPage {
    private SelenideElement safeName = $(By.id("input_groupAdd"));

    public SafeAddPage typeSafeName(String name){
        safeName.should(Condition.visible).sendKeys(name);
        return this;
    }

    public MainPage pressEnter(){
        safeName.should(Condition.visible).pressEnter();
        return new MainPage();
    }

}
