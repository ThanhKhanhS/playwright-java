package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.base.BasePage;

public class LoginPage extends BasePage {

    private static final String Username_Input = "//label[text()='Username']/following-sibling::input";
    private static final String Password_Input = "//label[text()='Password']/following-sibling::input";
    private static final String Login_Btn      = "//button[text()='Login']";

    private static final String Success_Msg    = "//div[@id='flash']";
    private static final String Logout_Btn     = "//i[normalize-space()='Logout']/parent::a";

    private static final String Error_Msg      = "//div[@id='flash']";

    public LoginPage(Page page){
        super(page);
    }

    public void login(String username, String password) {
        fill(Username_Input,username);
        fill(Password_Input,password);
        click(Login_Btn);
        page.waitForLoadState();
    }

    public String getSuccessMessage(){
        return getText(Success_Msg);
    }

    public String getErrorMessage(){
        return getText(Error_Msg);
    }

    public boolean isLogoutButtonVisible(){
        return page.locator(Logout_Btn).isVisible();
    }

    public boolean isOnSecurePage(){
        return page.url().equals("https://practice.expandtesting.com/secure");
    }
}
