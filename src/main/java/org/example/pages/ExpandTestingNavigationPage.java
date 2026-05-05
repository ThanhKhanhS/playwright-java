package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;

public class ExpandTestingNavigationPage {
    private final Page page;

    private static final String Link_By_Text = "//h3[a[normalize-space()='%s']]/a";

    public ExpandTestingNavigationPage(Page page){
        this.page = page;
    }

    public void navigateTo(String cardTitle){
        page.locator(String.format(Link_By_Text, cardTitle)).click();
    }
}