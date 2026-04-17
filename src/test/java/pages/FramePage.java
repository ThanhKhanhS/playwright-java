package pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class FramePage {

    private final Page page;

    private static final String IFRAME_1 = "//h2[text()='Iframe 1']/following-sibling::iframe[1]";
    private static final String IFRAME_2 = "//h2[text()='Iframe 2']/following-sibling::iframe[1]";

    private static final String SELENIUM_TUTORIAL_LINK = "//a[normalize-space()='Selenium Tutorial']";

    public FramePage(Page page) {
        this.page = page;
    }
    public Page clickSeleniumTutorialInFrame(String iframeXpath) {
        FrameLocator frame = page.frameLocator(iframeXpath);

        Page newTab = page.waitForPopup(() -> {
            frame.locator(SELENIUM_TUTORIAL_LINK).click();
        });
        return newTab;
    }

    public Page clickInIframe1() {
        return clickSeleniumTutorialInFrame(IFRAME_1);
    }

    public Page clickInIframe2() {
        return clickSeleniumTutorialInFrame(IFRAME_2);
    }
}