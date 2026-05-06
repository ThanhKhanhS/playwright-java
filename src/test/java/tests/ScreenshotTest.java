package tests;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.LoginScreenShotPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Paths;

public class ScreenshotTest extends BaseTest {

    private static final String Valid_Username = "student";
    private static final String Valid_Password = "Password123";
    private static final String Screenshot_Dir = System.getProperty("user.dir") + File.separator + "src/test/java/resources/screenshot";
    private LoginScreenShotPage loginPage;
    @BeforeMethod
        public void setupTest(){
        page.navigate(URLs.PracticeTest_Home);
        loginPage = new LoginScreenShotPage(page);
    }
    @Test
    public void TC01_screenshotLoginPage(){
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC01_login_page.png")).setFullPage(true));
    }
    @Test
    public void TC02_screenshotLoginFailed(){
        loginPage.login("sdxasx", "ikmujn");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC02_login_failed.png")));
        Assert.assertFalse(loginPage.isLoginSuccess());
        Assert.assertEquals(loginPage.getErrorMsg(),"Your username is invalid!");
    }
    @Test
    public void TC03_screenshotLoginSuccess(){
        loginPage.login(Valid_Username,Valid_Password);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC03_login_success.png")));
        Assert.assertTrue(loginPage.isLoginSuccess());
    }
    @Test
    public void TC04_screenshotLoginFailedWithWrongPassword(){
        loginPage.login(Valid_Username,"zxcvbnm");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC04_login_failed_wrongpassword.png")));
        Assert.assertEquals(loginPage.getErrorMsg(),"Your password is invalid!");
    }
    @Test
    public void TC05_screenshotElementErrorMsg(){
        loginPage.login("ikmnju","yuiohjk");
        Locator errorMsg = loginPage.getErrorLocator();
        errorMsg.waitFor();
        errorMsg.screenshot(new Locator.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC05_error_element.png")));
    }
}

