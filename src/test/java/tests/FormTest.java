package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FormPage;

public class FormTest extends BaseTest {
    @Test
    public void TC01_fillForm() {
        FormPage formPage = new FormPage(page);

        formPage.navigate();
        formPage.fillForm();
        formPage.submit();

    }
}