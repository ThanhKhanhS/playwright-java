package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.base.BasePage;

import java.util.Locale;

public class LoginScreenShotPage extends BasePage {
    private static final String Email_Input    = "//label[text()='Email']/following-sibling::div/input";
    private static final String Password_Input = "//label[text()='Password']/following-sibling::div/input";
    private static final String Login_Btn      = "//button[normalize-space()='Login']";
    private static final String Error_Msg      = "//span[@class='title text-black text-md']";
    private static final String Error_Box      = "//span[@id='remove-toaster']/parent::div";
    private static final String Logout_Btn     = "//button[normalize-space()='Logout']";

    public LoginScreenShotPage(Page page) {
        super(page);
    }

    public void login(String username, String password){
        fill(Email_Input,username);
        fill(Password_Input,password);
        click(Login_Btn);
    }
    public boolean isLoginSuccess(){
        try {
            page.locator(Logout_Btn).waitFor();
            return page.locator(Logout_Btn).isVisible();
        }catch (Exception e) {
            return false;
        }
    }
    public String getErrorMsg(){
        return getText(Error_Msg);
    }
    public Locator getErrorLocator(){
        return page.locator(Error_Box);
    }
    public void clickLogin(){
        click(Login_Btn);
        page.waitForLoadState();
    }
}
