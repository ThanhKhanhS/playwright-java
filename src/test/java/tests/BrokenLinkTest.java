package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.BrokenLinkPage;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;

public class BrokenLinkTest extends BaseTest {

    @Test
    public void TC01_getBrokenLink(){
        page.navigate(URLs.BROKEN);
        BrokenLinkPage brokenLinkPage = new BrokenLinkPage(page);

        List<String> urls = brokenLinkPage.getAllBrokenLinkUrl();
        List<String> brokenLinkFound = new ArrayList<>();

        for(int i = 0; i < urls.size(); i++) {
            String currentUrls = urls.get(i);
            if(brokenLinkPage.isBrokenLink(currentUrls)) {
                brokenLinkFound.add(currentUrls);
            }
        }
        for(int i = 0;i< brokenLinkFound.size(); i++){
            System.out.println(brokenLinkFound.get(i));
        }
    }
}
