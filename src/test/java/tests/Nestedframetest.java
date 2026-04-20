package tests;

import base.BaseTest;
import constants.URLs;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NestedFramePage;

public class Nestedframetest extends BaseTest {
    private NestedFramePage nestedFramePage;

    @BeforeMethod
    public void setupTest() {
        page.navigate(URLs.NESTED_FRAME);
        nestedFramePage = new NestedFramePage(page);
    }

    @Test
    public void TC01_clickHereInParentFrameAndVerifyText() {
        String headerText = nestedFramePage.getParentHeaderText();
        Assert.assertEquals(headerText, "Parent iframe", "Tiêu đề Parent frame không đúng");

        nestedFramePage.clickInParentFrame();

        String successMsg = nestedFramePage.getParentSuccessMessage();
        Assert.assertTrue(successMsg.contains("You clicked the button from iframe 1"),
                "Tin nhắn thành công ở Parent frame không hiển thị đúng");
    }

    @Test
    public void TC02_clickHereInChildFrameAndVerifyText() {

        String headerText = nestedFramePage.getChildHeaderText();
        Assert.assertEquals(headerText, "iframe 2", "Tiêu đề Child frame không đúng");

        nestedFramePage.clickInChildFrame();

        String successMsg = nestedFramePage.getChildSuccessMessage();
        Assert.assertTrue(successMsg.contains("You clicked the button from iframe 2"),
                "Tin nhắn thành công ở Child frame không hiển thị đúng");
    }
}
