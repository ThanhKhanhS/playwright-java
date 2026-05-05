package tests;

import com.microsoft.playwright.Page;
import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.DummySiteLoginPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ScreenshotTest extends BaseTest {

    private static final String Valid_Username = "demo";
    private static final String Valid_Password = "demo123";
    private static final String Screenshot_Dir = System.getProperty("user.dir") + File.separator + "src/test/java/resources/testdata/screenshot";
    private DummySiteLoginPage loginPage;
    @BeforeMethod
        public void setupTest(){
        page.navigate(URLs.DummySite_Home);
        loginPage = new DummySiteLoginPage(page);
        loginPage.gotoLoginPage();
    }
    @Test
    public void TC01_screenshotLoginPage(){
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC01_login_page.png")));
    }
    @Test
    public void TC02_screenshotLoginFailed(){
        loginPage.login("sdxasx", "ikmujn");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC02_login_failed.png")));
        Assert.assertFalse(loginPage.isLoginSuccess());
    }
    @Test
    public void TC03_screenshotLoginSuccess(){
        loginPage.login(Valid_Username,Valid_Password);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(Screenshot_Dir,"TC03_login_success.png")));
        Assert.assertTrue(loginPage.isLoginSuccess());
    }
}

