package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.base.BasePage;

public class KeyPressPage extends BasePage {

    private static final String Key_Input  = "//input[@id='target']";
    private static final String Result_Msg = "//p[@id='result']";

    public KeyPressPage(Page page) {
        super(page);
    }

    public String pressKeyAndGetResult(String key){
        page.locator(Key_Input).click();
        page.keyboard().press(key);
        return getText(Result_Msg);
    }
}
