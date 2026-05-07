package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.LoginScreenShotPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;

public class ScreenshotTest extends BaseTest {

    private static final String Valid_Email = "qa_testers@qabrains.com";
    private static final String Valid_Password = "Password123";
    private LoginScreenShotPage loginPage;
    @BeforeMethod
        public void setupTest(){
        page.navigate(URLs.PracticeTest_Home);
        loginPage = new LoginScreenShotPage(page);
    }
    @Test
    public void TC01_screenshotLoginPage(){
       captureScreenshot();
    }
    @Test
    public void TC02_screenshotLoginFailed(){
        loginPage.login("sdxasx@gmail.com", "ikmujn");
        waitForPage();
        captureScreenshot();
        Assert.assertFalse(loginPage.isLoginSuccess());
        Assert.assertEquals(loginPage.getErrorMsg(),"Your email and password both are invalid!");
    }
    @Test
    public void TC03_screenshotLoginSuccess(){
        loginPage.login(Valid_Email,Valid_Password);
        waitForPage();
        captureScreenshot();
        Assert.assertTrue(loginPage.isLoginSuccess());
    }
    @Test
    public void TC04_screenshotLoginFailedWithWrongPassword(){
        loginPage.login(Valid_Email,"zxcvbnm");
        waitForPage();
        captureScreenshot();
        Assert.assertEquals(loginPage.getErrorMsg(),"Your password is invalid!");
    }
    @Test
    public void TC05_screenshotElementErrorMsg(){
        loginPage.login("ikmnju@gmail.com","yuiohjk");
        Locator errorMsg = loginPage.getErrorLocator();
        errorMsg.waitFor();
        captureScreenshotElement(errorMsg);
    }
    @Test
    public void TC06_screenshotWithEmptyCred(){
        loginPage.clickLogin();
        captureScreenshot();
    }
    @Test
    public void TC07_screenshotViewPort(){
        captureScreenshotViewPort();
    }
}

