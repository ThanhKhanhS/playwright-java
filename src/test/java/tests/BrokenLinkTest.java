package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.BrokenLinkPage;
import org.testng.annotations.Test;

import java.util.List;

public class BrokenLinkTest extends BaseTest {

    @Test
    public void TC01_getBrokenLink(){
        page.navigate(URLs.BROKEN);
        BrokenLinkPage brokenLinkPage = new BrokenLinkPage(page);

        List<String> urls = brokenLinkPage.getAllBrokenLinkUrl();
        System.out.println("Total link: " + urls.size());
        int count = 0;
        for (String url : urls) {
            if(brokenLinkPage.isBrokenLink(url)) {
                System.out.println(url);
                count ++;
            }
        }
    }
}
