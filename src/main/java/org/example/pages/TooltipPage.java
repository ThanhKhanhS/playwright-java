package org.example.pages;

import com.microsoft.playwright.Page;

public class TooltipPage {
    private final Page page;

    private static final String Btn_tooltip = "//button[normalize-space(text())='%s']";
    private static final String Tooltip_content = "//div[@class='tooltip-inner']";

    public TooltipPage(Page page){
        this.page =page;
    }

    public String hoverAndGetToolTip(String buttonText) {
        page.locator(String.format(Btn_tooltip, buttonText)).hover();
        page.locator(Tooltip_content).waitFor();
        return page.locator(Tooltip_content).innerText();
    }
}
