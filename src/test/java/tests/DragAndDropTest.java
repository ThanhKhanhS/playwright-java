package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.DragAndDropPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends BaseTest {

    @Test
    public void dragAndDropAndVerifySuccessMessage(){
        page.navigate(URLs.DRAGANDDROP);
        DragAndDropPage dragAndDropPage = new DragAndDropPage(page);

        String textBefore = dragAndDropPage.getDropResultText();

        dragAndDropPage.dragAndDrop();

        String textAfter = dragAndDropPage.getDropResultText();

        Assert.assertNotEquals(textAfter, textBefore);
    }
}
