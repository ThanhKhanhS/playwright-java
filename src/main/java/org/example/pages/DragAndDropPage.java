package org.example.pages;

import com.microsoft.playwright.Page;

public class DragAndDropPage {
    private final Page page;

    private static final String Drag_el = "//div[@id='draggable']";
    private static final String Drop_el = "//div[@id='droppable']";

    private static final String Drop_Success_Text = "//div[@id='droppable']/p";

    public DragAndDropPage(Page page) {
        this.page = page;
    }

    public void dragAndDrop(){
        page.dragAndDrop(Drag_el, Drop_el);
    }

    public String getDropResultText(){
        return page.locator(Drop_Success_Text).innerText();
    }

}
