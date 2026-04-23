package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import java.util.List;

public class DropdownPage {
    private final Page page;

    private static final String Multi_select = "//input[@id='%s']";
    private static final String Item_select  = "//div[@role='option' and normalize-space(.)='%s']";

    private static final String Select_one   = "//select[@id='%s']";

    public DropdownPage(Page page) {
        this.page = page;
    }

    public void selectMultipleOptions(String inputId, List<String> values) {
        page.click(String.format(Multi_select,inputId), new Page.ClickOptions().setForce(true));

        for(String value : values) {
            String item = String.format(Item_select,value);
            page.locator(item).click();
        }

        page.click("body");
    }

    public void selectOneOption(String id, String label) {
        String xpath = String.format(Select_one, id);
        page.selectOption(xpath, new SelectOption().setLabel(label));
    }
}
