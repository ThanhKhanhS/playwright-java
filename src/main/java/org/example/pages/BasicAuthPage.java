package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.base.BasePage;

public class BasicAuthPage extends BasePage {
    public static final String Success_Msg = "//p[@class='alert alert-success']/b";

    public BasicAuthPage (Page page) {
        super(page);
    }
    public String getSuccess_Msg(){
        return getText(Success_Msg);
    }
}
