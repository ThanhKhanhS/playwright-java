package org.example.pages;

import com.microsoft.playwright.Page;

public class AlertPopupPage {
    private final Page page;

    private static final String Alert_btn  = "//button[@id='%s']";
    private static final String OPEN_NEW_WINDOWS_BTN = "//button[text()='%s']";

    public AlertPopupPage(Page page) {
        this.page = page;
    }

    public void triggerAlert(String buttonId) {
        String xpath = String.format(Alert_btn, buttonId);
        page.click(xpath);
    }

    public Page openNewWindow(String buttonText) {
        String xpath = String.format(OPEN_NEW_WINDOWS_BTN, buttonText);
        return page.waitForPopup(() -> {
            page.click(xpath);
        });
    }
}