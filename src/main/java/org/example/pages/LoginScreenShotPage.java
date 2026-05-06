package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.base.BasePage;

import java.util.Locale;

public class LoginScreenShotPage extends BasePage {
    private static final String Username_Input = "//label[text()='Username']/following-sibling::input";
    private static final String Password_Input = "//label[text()='Password']/following-sibling::input";
    private static final String Submit_Btn     = "//button[normalize-space()='Submit']";
    private static final String Error_Msg      = "//div[@id='error']";
    private static final String Error_Box      = "//div[@id='error']";

    public LoginScreenShotPage(Page page) {
        super(page);
    }

    public void login(String username, String password){
        fill(Username_Input,username);
        fill(Password_Input,password);
        click(Submit_Btn);
        page.waitForLoadState();
    }
    public boolean isLoginSuccess(){
        return page.url().equals("https://practicetestautomation.com/logged-in-successfully/");
    }
    public String getErrorMsg(){
        return getText(Error_Msg);
    }
    public Locator getErrorLocator(){
        return page.locator(Error_Box);
    }
}
