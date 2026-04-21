package org.example.pages;

import com.microsoft.playwright.Page;

public class TooltipPage {
    private final Page page;

    private static final String Btn_tooltip = "//button[normalize-space(text())='%s']";

    public TooltipPage(Page page){
        this.page =page;
    }

    public String getTooltipTitle(String buttonText) {
        String xpath = String.format(Btn_tooltip, buttonText);
        return page.getAttribute(xpath, "title");
    }

    public void hoverOnButton(String buttonText) {
        String xpath = String.format(Btn_tooltip, buttonText);
        page.hover(xpath);
    }
}
