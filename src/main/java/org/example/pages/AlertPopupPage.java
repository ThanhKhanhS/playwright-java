package org.example.pages;

import com.microsoft.playwright.Page;

public class AlertPopupPage {
    private final Page page;

    private static final String Alert_btn  = "//button[text()='%s']";
    private static final String OPEN_NEW_WINDOWS_BTN = "//button[text()='%s']";

    public AlertPopupPage(Page page) {
        this.page = page;
    }

    public void triggerAlert(String buttonName) {
        String xpath = String.format(Alert_btn, buttonName);
        page.click(xpath);
    }

    public Page openNewWindow(String buttonText) {
        String xpath = String.format(OPEN_NEW_WINDOWS_BTN, buttonText);
        return page.waitForPopup(() -> {
            page.click(xpath);
        });
    }
}