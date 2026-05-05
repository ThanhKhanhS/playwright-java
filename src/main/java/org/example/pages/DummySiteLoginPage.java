package org.example.pages;

import com.microsoft.playwright.Page;
import org.example.base.BasePage;

public class DummySiteLoginPage extends BasePage {
    private static final String Login_Link     = "//a[normalize-space()='Login']";
    private static final String Username_Input = "//input[@id='username']";
    private static final String Password_Input = "//input[@id='password']";
    private static final String SignIn_Btn     = "//button[normalize-space()='Sign In']";
    private static final String Error_Msg      = "//div[@class='alert alert-error']";

    public DummySiteLoginPage(Page page) {
        super(page);
    }

    public void gotoLoginPage(){
        click(Login_Link);
        page.waitForLoadState();
    }
    public void login(String username, String password){
        fill(Username_Input,username);
        fill(Password_Input,password);
        click(SignIn_Btn);
        page.waitForLoadState();
    }
    public boolean isLoginSuccess(){
        return page.url().equals("https://thedummysite.com/panel");
    }
    public String getErrorMsg(){
        return getText(Error_Msg);
    }
}
