package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    private static final String Valid_Username   = "practice";
    private static final String Valid_Password   = "SuperSecretPassword!";
    private static final String Invalid_Username = "khanh";
    private static final String Invalid_Password = "123123zxc";

    @Test
    public void TC01_loginSuccessfully(){
        page.navigate(URLs.LOGIN);
        LoginPage loginPage = new LoginPage(page);

        loginPage.login(Valid_Username,Valid_Password);

        Assert.assertTrue(loginPage.isOnSecurePage());

        String successMsg = loginPage.getSuccessMessage();
        Assert.assertEquals(successMsg,"You logged into a secure area!");

        Assert.assertTrue(loginPage.isLogoutButtonVisible());
    }

    @Test
    public void TC02_loginWithInvalidUsername(){
        page.navigate(URLs.LOGIN);
        LoginPage loginPage = new LoginPage(page);

        loginPage.login(Invalid_Username, Valid_Password);

        String errorMsg = loginPage.getErrorMessage();
        Assert.assertEquals(errorMsg,"Your username is invalid!");

        Assert.assertFalse(loginPage.isOnSecurePage());
    }

    @Test
    public void TC03_loginWithInvalidPassword(){
        page.navigate(URLs.LOGIN);
        LoginPage loginPage = new LoginPage(page);

        loginPage.login(Valid_Username, Invalid_Password);

        String errorMsg = loginPage.getErrorMessage();
        Assert.assertEquals(errorMsg,"Your password is invalid!");

        Assert.assertFalse(loginPage.isOnSecurePage());
    }
}
