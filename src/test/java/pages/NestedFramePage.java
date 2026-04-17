package pages;

import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;

public class NestedFramePage {

    private final Page page;

    // ===== IFRAME LOCATOR =====

    // Trang này có 2 iframe → dùng index
    private FrameLocator outerFrame() {
        return page.frameLocator("//iframe[@id='parent_iframe']");
    }

    private FrameLocator innerFrame() {
        return outerFrame().frameLocator("//iframe[@id='iframe1']");
    }

    // ===== ELEMENT =====

    private static final String CLICK_HERE_BTN = "//button[text()='Click Here']";

    private static final String BODY = "//body";

    public NestedFramePage(Page page) {
        this.page = page;
    }

    // ===== ACTION =====

    // Click button trong CHILD frame (deep nhất)
    public void clickChildButton() {
        innerFrame()
                .locator(CLICK_HERE_BTN)
                .click();
    }

    // (optional) click parent button
    public void clickParentButton() {
        outerFrame()
                .locator(CLICK_HERE_BTN)
                .click();
    }

    // ===== GET TEXT =====

    public String getOuterFrameText() {
        return outerFrame()
                .locator(BODY)
                .innerText()
                .trim();
    }

    public String getInnerFrameText() {
        return innerFrame()
                .locator(BODY)
                .innerText()
                .trim();
    }
}