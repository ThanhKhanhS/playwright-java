package org.example.pages;

import com.microsoft.playwright.Page;

import java.util.List;

public class BrokenLinkPage {
    private final Page page;

    private static final String Broken_Link = "//h4[text()='Broken Links']/following-sibling::a";

    public BrokenLinkPage(Page page){
        this.page = page;
    }

    public List<String> getAllBrokenLinkUrl() {
        return page.locator(Broken_Link).all()
                .stream()
                .map(locator -> locator.getAttribute("href"))
                .toList();
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
