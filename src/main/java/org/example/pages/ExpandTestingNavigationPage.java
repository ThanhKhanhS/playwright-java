package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class ExpandTestingNavigationPage {
    private final Page page;

    private static final String Try_It_Out_Btn = "//h3[a[normalize-space()='%s']]/ancestor::div[contains(@class,'card')]//a[normalize-space()='Try it out']";

    public ExpandTestingNavigationPage(Page page){
        this.page = page;
    }

    public void navigateTo(String cardTitle){
        page.locator(String.format(Try_It_Out_Btn, cardTitle)).click();
        page.waitForLoadState();
    }
}