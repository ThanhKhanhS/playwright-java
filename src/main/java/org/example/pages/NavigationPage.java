package org.example.pages;

import com.microsoft.playwright.Page;

public class NavigationPage {
    private final Page page;

    private static final String Auto_Practice_Link = "//a[@href='/selenium/selenium_automation_practice.htm']";

    private static final String Accordion_Btn = "//button[normalize-space(.)='%s']";

    private static final String Menu_Link = "//li[@class='list-group-item']//a[normalize-space(text())='%s']";

    public NavigationPage(Page page) {
        this.page = page;
    }

    public void navigateTo(String accordionName, String linkText){
        page.locator(Auto_Practice_Link).click();
        page.waitForLoadState();
        page.locator(String.format(Accordion_Btn, accordionName)).click();

        page.locator(String.format(Menu_Link, linkText)).click();
        page.waitForLoadState();
    }
}
