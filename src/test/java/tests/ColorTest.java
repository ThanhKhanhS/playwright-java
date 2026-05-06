package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.ColorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ColorTest extends BaseTest {
    @Test
    public void TC01_getStartButtonColorOnHover(){
        page.navigate(URLs.Color);
        ColorPage colorPage = new ColorPage(page);
        String btnName = "START";

        String colorBefore = colorPage.getButtonColor(btnName);
        System.out.println(btnName + "Button color normal " + colorBefore);

        String colorAfter = colorPage.getButtonColorOnHover(btnName);
        System.out.println(btnName + "Button color hover " + colorAfter);

        Assert.assertNotEquals(colorAfter,colorBefore);
    }
}
