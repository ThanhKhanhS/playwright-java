package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.BasicAuthPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicAuthTest extends BaseTest {
    public static final String Username = "admin";
    public static final String Password = "admin";
    public static final String Expected_Msg = "Congratulations! You must have the proper credentials.";

    @Test
    public void TC01_basicAuthWithCredInUrl(){
        String urlWithCred = String.format("https://%s:%s@practice.expandtesting.com/basic-auth",Username,Password);
        page.navigate(urlWithCred);

        BasicAuthPage basicAuthPage = new BasicAuthPage(page);
        String message = basicAuthPage.getSuccess_Msg();
        Assert.assertEquals(message,Expected_Msg);
    }

    @Test
    public void TC02_basicAuthWithHTTPCred() {
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials(Username,Password));
        Page newPage = context.newPage();
        newPage.navigate(URLs.BASIC_AUTH);

        BasicAuthPage basicAuthPage = new BasicAuthPage(newPage);
        String message = basicAuthPage.getSuccess_Msg();
        Assert.assertEquals(message,Expected_Msg);
        context.close();
    }
}
