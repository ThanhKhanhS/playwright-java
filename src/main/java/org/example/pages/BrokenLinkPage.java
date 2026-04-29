package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Locator;
import java.util.List;
import java.util.ArrayList;

public class BrokenLinkPage {
    private final Page page;

    private static final String Broken_Link = "//h4[text()='Broken Links']/following-sibling::a";

    public BrokenLinkPage(Page page){
        this.page = page;
    }

    public List<String> getAllBrokenLinkUrl() {
        List<String> urls = new ArrayList<>();
        List<Locator> links = page.locator(Broken_Link).all();
        for(int i = 0; i < links.size(); i++) {
            String href = links.get(i).getAttribute("href");
            if (href != null) {
                urls.add(href);
            }
        }
        return urls;
    }

    public boolean isBrokenLink(String url){
        try{
            int status = page.request().head(url).status();
            return status >=400;
        } catch (Exception e) {
            return true;
        }
    }
}
