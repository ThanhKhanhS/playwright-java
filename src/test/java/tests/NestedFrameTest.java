package tests;

import base.BaseTest;
import constants.URLs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NestedFrameTest extends BaseTest {
    private pages.NestedFramePage nestedFramePage;

    @BeforeMethod
    public void setupTest() {
        page.navigate(URLs.NESTED_FRAME);
        nestedFramePage = new pages.NestedFramePage(page);
    }

    @Test
    public void TC01_clickHereInParentFrameAndVerifyText() {
        String headerText = nestedFramePage.getParentHeaderText();
        Assert.assertEquals(headerText, "Parent iframe", "The title Parent frame is incorrect");

        nestedFramePage.clickInParentFrame();

        String successMsg = nestedFramePage.getParentSuccessMessage();
        Assert.assertEquals(successMsg,"You clicked the button from iframe 1",
                "The message displayed is incorrect");
    }

    @Test
    public void TC02_clickHereInChildFrameAndVerifyText() {

        String headerText = nestedFramePage.getChildHeaderText();
        Assert.assertEquals(headerText, "iframe 2", "The title Child frame is incorrect");

        nestedFramePage.clickInChildFrame();

        String successMsg = nestedFramePage.getChildSuccessMessage();
        Assert.assertEquals(successMsg,"You clicked the button from iframe 2",
                "The message displayed is incorrect");
    }
}
