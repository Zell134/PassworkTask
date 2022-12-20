package ru.passworkDemo.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SafePage {

    private SelenideElement safeSettingsBtn = $(By.xpath("//div[contains(@class,'main__right-header')]//a[contains(@data-drop-content,'dd-settings')]"));
    private SelenideElement deleteSafeBtn = $(By.xpath("//div[@class='drop-content']/div[@id='dd-settings']//a[6]"));
    private SelenideElement confirmDeleteBtn = $(By.xpath("//div[@id='popup-delete-group']//button[@class='button button_deny']"));

    public MainPage deleteSafe(){
        safeSettingsBtn.should(Condition.visible).click();
        deleteSafeBtn.should(Condition.visible).click();
        confirmDeleteBtn.should(Condition.visible).click();
        return new MainPage();
    }

}
