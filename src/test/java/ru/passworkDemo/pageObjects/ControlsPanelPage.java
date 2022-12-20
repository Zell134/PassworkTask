package ru.passworkDemo.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$;

public class ControlsPanelPage {

    private ElementsCollection organizationSafes = $$(By.xpath("//div[contains(@class, 'harp_dd_unfolded') and not(contains(@class,'ng-scope'))]//a"));
    private ElementsCollection selfSafes = $$(By.xpath("//div[contains(@class, 'harp_dd_unfolded') and contains(@class,'ng-scope')]//a"));
    private SelenideElement addOrganizationSafeBtn = $(By.xpath("//div[contains(@class, 'harp_dd_unfolded') and not(contains(@class,'ng-scope'))]//button[contains(@class, 'button_add-group')]"));
    private SelenideElement addSelfSafeBtn = $(By.xpath("//div[contains(@class, 'harp_dd_unfolded') and contains(@class,'ng-scope')]//button[contains(@class, 'button_add-group')]"));

    public ControlsPanelPage isSafeContainsInOrganizationSafes(String safeName) {
        isSafeContainsInList(organizationSafes, safeName);
        return this;
    }

    public ControlsPanelPage isSafeNotPresentInOrganizationSafes(String safeName) {
        isSafeNotPresentInList(organizationSafes, safeName);
        return this;
    }

    public ControlsPanelPage isSafeContainsInSelfSafes(String safeName) {
        isSafeContainsInList(selfSafes, safeName);
        return this;
    }

    public ControlsPanelPage isSafeNotPresentInSelfSafes(String safeName) {
        isSafeNotPresentInList(selfSafes, safeName);
        return this;
    }

    public SafeAddPage addOrganizationSafe() {
        addOrganizationSafeBtn.should(Condition.visible).click();
        return new SafeAddPage();
    }

    public SafeAddPage addSelfSafe() {
        addSelfSafeBtn.should(Condition.visible).click();
        return new SafeAddPage();
    }

    public SafePage openOrganizationSafe(String safeName) {
        clickOnSafeWithText(organizationSafes, safeName);
        return new SafePage();
    }

    public SafePage openOnSelfSafe(String safeName) {
        clickOnSafeWithText(selfSafes, safeName);
        return new SafePage();
    }

    private void clickOnSafeWithText(ElementsCollection collection, String safeName) {
        collection.findBy(Condition.exactText(safeName)).should(Condition.visible).click();
    }

    private void isSafeContainsInList(ElementsCollection collection, String safeName) {
        collection.findBy(Condition.exactText(safeName)).should(Condition.visible);
    }

    private void isSafeNotPresentInList(ElementsCollection collection, String safeName) {
        collection.findBy(Condition.exactText(safeName)).should(not(Condition.exist));
    }
}
