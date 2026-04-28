package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class DropdownPage {
    private final Page page;

    private static final String Multi_select = "//h6[normalize-space()='%s']/following-sibling::div//input";
    private static final String Item_select  = "//div[@role='option' and normalize-space(.)='%s']";

    private static final String Select_one   = "//h6[normalize-space()='%s']/following-sibling::div/select";

    public DropdownPage(Page page) {
        this.page = page;
    }

    public void selectMultipleOptions(String selectLabel, List<String> values) {
        page.click(String.format(Multi_select,selectLabel), new Page.ClickOptions().setForce(true));

        for(String value : values) {
            String item = String.format(Item_select,value);
            page.locator(item).click();
        }

        page.click(String.format(Multi_select,selectLabel), new Page.ClickOptions().setForce(true));
        page.waitForTimeout(5_000);
    }

    public void selectOneOption(String id, String label) {
        String xpath = String.format(Select_one, id);
        page.selectOption(xpath, new SelectOption().setLabel(label));
    }
}
