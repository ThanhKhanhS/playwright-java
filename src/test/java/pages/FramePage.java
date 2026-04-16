package pages;

import com.microsoft.playwright.Page;

public class FramePage {

    private Page page;

    public FramePage(Page page) {
        this.page = page;
    }
    private String url = "https://www.tutorialspoint.com/selenium/practice/frames.php";

    public void navigate() {
        page.navigate(url);
    }

    public Page clickInFrame1() {
        return page.waitForPopup(() -> {
            page.frameLocator("(//iframe[@src='new-tab-sample.php'])[1]")
                    .locator("(//a[normalize-space()='Selenium Tutorial'])")
                    .click();
        });
    }
    public Page clickInFrame2() {
        return page.waitForPopup(() -> {
            page.frameLocator("(//iframe[@src='new-tab-sample.php'])[2]")
                    .locator("(//a[normalize-space()='Selenium Tutorial'])")
                    .click();
        });
    }

}