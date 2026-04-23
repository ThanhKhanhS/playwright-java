package tests;

import org.example.base.BaseTest;
import constants.URLs;
import org.testng.annotations.Test;
import org.example.pages.FormPage;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

public class FormTest extends BaseTest {

    @Test
    public void TC01_fillStudentRegistrationForm() {

        FormPage formPage = new FormPage(page);

        formPage.navigate(URLs.FORM);

        String path = System.getProperty("user.dir");
        String imagePath = path + File.separator + "src/test/java/resources/testdata/anh.png";

        Map<String, String> data = new LinkedHashMap<>();
        data.put("Name", "Khanh");
        data.put("Email", "test@gmail.com");
        data.put("Mobile(10 Digits)", "0123456789");
        data.put("Date of Birth", "2000-10-10");
        data.put("Current Address", "Quy Nhon");
        data.put("Gender", "Male");
        data.put("Subjects", "Math");
        data.put("Hobbies", "Sports");
        data.put("state", "NCR");
        data.put("city", "Agra");
        data.put("Picture", imagePath);
        formPage.fillStudentRegistrationForm(data);
        page.waitForTimeout(2_000);
        formPage.submit();
    }
}