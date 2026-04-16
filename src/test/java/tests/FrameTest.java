package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FramePage;

public class FrameTest extends BaseTest {

    @Test
    public void testFrame1() {
        FramePage framePage = new FramePage(page);
        framePage.navigate();
        Page newTab = framePage.clickInFrame1();
        Assert.assertNotNull(newTab);
        Assert.assertTrue(newTab.url().contains("selenium"));
    }
    @Test
    public void testFrame2(){
        FramePage framePage = new FramePage(page);
        framePage.navigate();
        Page newTab = framePage.clickInFrame2();
        Assert.assertNotNull(newTab);
        Assert.assertTrue(newTab.url().contains("selenium"));
    }

}