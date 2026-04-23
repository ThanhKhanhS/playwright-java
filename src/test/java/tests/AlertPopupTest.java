package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.AlertPopupPage;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertPopupTest extends BaseTest {
    private AlertPopupPage alertPage;

    @BeforeMethod
    public void setupTest() {
        page.navigate(URLs.ALERTPOPUP);
        alertPage = new AlertPopupPage(page);
    }

    @Test
    public void TC01_HandleAllAlerts() {
        page.onceDialog(dialog -> {
            Assert.assertEquals(dialog.message(), "I am an alert box!");
            dialog.accept();
        });
        alertPage.triggerAlert("alertBtn");

        page.onceDialog(dialog -> {
            Assert.assertEquals(dialog.message(), "Press a button!");
            dialog.dismiss();
        });
        alertPage.triggerAlert("confirmBtn");

        page.onceDialog(dialog -> {
            Assert.assertEquals(dialog.message(), "Please enter your name:");
            dialog.accept("Khanh");
        });
        alertPage.triggerAlert("promptBtn");
    }

    @Test
    public void TC02_VerifyNewWindows() {
        Page newTab = alertPage.openNewWindow("New Tab");
        Assert.assertNotNull(newTab);
        newTab.close();

        Page popup = alertPage.openNewWindow("Popup Windows");
        Assert.assertNotNull(popup);
        popup.close();
    }
}