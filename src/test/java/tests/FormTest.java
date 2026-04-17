package tests;

import base.BaseTest;
import constants.URLs;
import org.testng.annotations.Test;
import pages.FormPage;

import java.util.LinkedHashMap;
import java.util.Map;

public class FormTest extends BaseTest {

    @Test
    public void TC01_fillStudentRegistrationForm() {

        FormPage formPage = new FormPage(page);

        formPage.navigate(URLs.FORM);

        Map<String, String> data = new LinkedHashMap<>();
        data.put("Name:", "Khanh");
        data.put("Email:", "test@gmail.com");
        data.put("Mobile(10 Digits):", "0123456789");
        data.put("Date of Birth:", "2000-10-10");
        data.put("Current Address:", "Quy Nhon");
        data.put("Gender:", "Male");
        data.put("Hobbies:", "Sports");
        data.put("state", "NCR");
        data.put("city", "Agra");

        // Action
        formPage.fillForm(data);
        formPage.submit();
    }
}