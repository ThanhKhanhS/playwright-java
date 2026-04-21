package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.TooltipPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TooltipTest extends BaseTest {
    private TooltipPage tooltipPage;

    @BeforeMethod
    public void setupTest() {
        page.navigate(URLs.TOOLTIP);
        tooltipPage = new TooltipPage(page);
    }

    @Test
    public void TC01_hoverTooltipOnTop() {
        String buttonName = "Tooltip on top";
        tooltipPage.hoverOnButton(buttonName);
        String actualTooltip = tooltipPage.getTooltipTitle(buttonName);
        Assert.assertEquals(actualTooltip, "Tooltip on top");
    }

    @Test
    public void TC02_hoverTooltipOnRight() {
        String buttonName = "Tooltip on right";
        tooltipPage.hoverOnButton(buttonName);
        String actualTooltip = tooltipPage.getTooltipTitle(buttonName);
        Assert.assertEquals(actualTooltip, "Tooltip on right");
    }

    @Test
    public void TC03_hoverTooltipOnBottom() {
        String buttonName = "Tooltip on bottom";
        tooltipPage.hoverOnButton(buttonName);
        String actualTooltip = tooltipPage.getTooltipTitle(buttonName);
        Assert.assertEquals(actualTooltip, "Tooltip on bottom");
    }

    @Test
    public void TC04_hoverTooltipOnLeft() {
        String buttonName = "Tooltip on left";
        tooltipPage.hoverOnButton(buttonName);
        String actualTooltip = tooltipPage.getTooltipTitle(buttonName);
        Assert.assertEquals(actualTooltip, "Tooltip on left");
    }
}
