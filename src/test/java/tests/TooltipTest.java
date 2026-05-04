package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.ExpandTestingNavigationPage;
import org.example.pages.NavigationPage;
import org.example.pages.TooltipPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TooltipTest extends BaseTest {
    private TooltipPage tooltipPage;

    @BeforeMethod
    public void setupTest() {
        page.navigate(URLs.Expand_Testing_Home);
        new ExpandTestingNavigationPage(page).navigateTo("Tooltips");
        tooltipPage = new TooltipPage(page);
    }

    @Test
    public void TC01_verifyTopToolTip(){
        String actualText = tooltipPage.hoverAndGetToolTip("Tooltip on top");
        Assert.assertEquals(actualText,"Tooltip on top");
    }
    @Test
    public void TC02_verifyEndToolTip(){
        String actualText = tooltipPage.hoverAndGetToolTip("Tooltip on end");
        Assert.assertEquals(actualText,"Tooltip on end");
    }
    @Test
    public void TC03_verifyBottomToolTip(){
        String actualText = tooltipPage.hoverAndGetToolTip("Tooltip on bottom");
        Assert.assertEquals(actualText,"Tooltip on bottom");
    }
    @Test
    public void TC04_verifyStartToolTip(){
        String actualText = tooltipPage.hoverAndGetToolTip("Tooltip on start");
        Assert.assertEquals(actualText,"Tooltip on start");
    }
    @Test
    public void TC05_verifyHTMLToolTip(){
        String actualText = tooltipPage.hoverAndGetToolTip("Tooltip with HTML");
        Assert.assertEquals(actualText,"Tooltip with HTML");
    }
}