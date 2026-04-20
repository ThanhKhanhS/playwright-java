package org.example.pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class FramePage {

    private final Page page;
    private static final String SELENIUM_TUTORIAL_LINK = "//a[normalize-space()='Selenium Tutorial']";
    private static final String iframeXpath = "//h2[contains(text(),'%s')]/following-sibling::iframe[1]";
    public FramePage(Page page) {
        this.page = page;
    }


    public Page clickSeleniumTutorialInFrame(String title) {

        String xpath = String.format(iframeXpath,title);
        FrameLocator frame = page.frameLocator(xpath);

        return page.waitForPopup(() -> {
            frame.locator(SELENIUM_TUTORIAL_LINK).click();
        });
    }

    public Page clickInIframe1() {
        return clickSeleniumTutorialInFrame("Iframe 1");
    }

    public Page clickInIframe2() {
        return clickSeleniumTutorialInFrame("Iframe 2");
    }
}