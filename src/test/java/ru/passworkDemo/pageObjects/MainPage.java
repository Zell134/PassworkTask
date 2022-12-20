package ru.passworkDemo.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {

    private SelenideElement accountOptionsBtn = $(By.xpath("//*[contains(@class, 'header__dots ')]"));

    public ControlsPanelPage withControlsPanel(){
        return new ControlsPanelPage();
    }

    public void logout(){
        accountOptionsBtn.should(Condition.visible).click();
        $$(By.xpath("//div[@id='dd-user']")).get(1).findElements(By.cssSelector("a")).get(5).click();
    }
}
