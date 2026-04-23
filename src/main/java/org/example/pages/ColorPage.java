package org.example.pages;

import com.microsoft.playwright.Page;

public class ColorPage {
    private final Page page;

    private static final String BTN = "//button[normalize-space()='%s']";

    public ColorPage(Page page) {
        this.page = page;
    }

    private String getBtnXpath(String btnText){
        return String.format(BTN, btnText);
    }

    private String getCssProperty(String xpath, String cssProperty) {
        return(String) page.locator(xpath).evaluate(String.format("el => window.getComputedStyle(el).getPropertyValue('%s')",cssProperty));
    }

    public String getButtonColor(String btnText){
        return getCssProperty(getBtnXpath(btnText),"background-color");
    }

    public String getButtonColorOnHover(String btnText) {
        String xpath = getBtnXpath(btnText);
        page.locator(xpath).hover();
        page.waitForTimeout(500);
        return getCssProperty(xpath, "background-color");
    }
}
