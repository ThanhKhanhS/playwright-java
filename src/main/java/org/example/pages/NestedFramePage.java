package org.example.pages;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitForSelectorState;

public class NestedFramePage {

    private final Page page;

    private static final String PARENT_IFRAME  = "//iframe[@id='parent_iframe']";
    private static final String CHILD_IFRAME   = "//iframe[@id='iframe1']";

    private static final String CLICK_HERE_BTN = "//button[normalize-space()='Click Here']";
    private static final String HEADER_TEXT    = "//br/preceding-sibling::h4";
    private static final String SUCCESS_MSG    = "//p[@id='processing']";

    public NestedFramePage(Page page) {
        this.page = page;
    }

    private FrameLocator parentFrame() {
        return page.frameLocator(PARENT_IFRAME);
    }

    private FrameLocator childFrame() {
        return parentFrame().frameLocator(CHILD_IFRAME);
    }

    public void clickInParentFrame() {
        parentFrame().locator(CLICK_HERE_BTN).first().click();
    }

    public void clickInChildFrame() {
        childFrame().locator(CLICK_HERE_BTN).click();
    }

    public String getParentHeaderText() {
        return parentFrame().locator(HEADER_TEXT).innerText().trim();
    }
    public String getChildHeaderText() {
        return childFrame().locator(HEADER_TEXT).innerText().trim();
    }
    public String getParentSuccessMessage() {
        Locator msg = parentFrame().locator(SUCCESS_MSG);
        msg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return msg.innerText();
    }

    public String getChildSuccessMessage() {
        Locator msg = childFrame().locator(SUCCESS_MSG);
        msg.waitFor(new Locator.WaitForOptions().setState(WaitForSelectorState.VISIBLE));
        return msg.innerText();
    }
}