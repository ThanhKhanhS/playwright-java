package tests;

import org.example.base.BaseTest;
import constants.URLs;
import org.example.pages.NavigationPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.pages.FramePage;
import com.microsoft.playwright.Page;

public class FrameTest extends BaseTest {

    @Test
    public void clickSeleniumTutorialInIframe1() {
        page.navigate(URLs.Home_Page);
        NavigationPage navigationPage = new NavigationPage(page);
        navigationPage.navigateTo("Alerts, Frames & Windows","Frames");

        FramePage framePage = new FramePage(page);

        Page newTab = framePage.clickInIframe1();

        Assert.assertEquals(newTab.url(),"https://www.tutorialspoint.com/selenium/index.htm");
        newTab.close();
    }

    @Test
    public void clickSeleniumTutorialInIframe2() {
        page.navigate(URLs.Home_Page);
        NavigationPage navigationPage = new NavigationPage(page);
        navigationPage.navigateTo("Alerts, Frames & Windows","Frames");

        FramePage framePage = new FramePage(page);

        Page newTab = framePage.clickInIframe2();

        Assert.assertEquals(newTab.url(), "https://www.tutorialspoint.com/selenium/index.htm");

        newTab.close();
    }
}