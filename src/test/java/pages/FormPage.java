package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

import java.nio.file.Paths;
import java.util.Map;
import java.io.File;

public class FormPage extends BasePage {

    public FormPage(Page page) {
        super(page);
    }

    private String textField(String label) {
        return String.format("//label[text()='%s']/following-sibling::div/input | //label[text()='%s']/following-sibling::div/textarea", label, label);
    }

    private String radioOrCheckbox(String label, String value) {
        return String.format("//label[text()='%s']/following-sibling::div//label[text()='%s']/preceding-sibling::input", label, value);
    }

    private String dropdown(String id) {
        return String.format("//select[@id='%s']", id);
    }

    private String fileUploadField(String label) {
        return String.format("//label[text()='%s']/following-sibling::div//input[@type='file']", label);
    }

    public void fileUpload(String label, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("EXCEPTION: File khong ton tai " + filePath);
        }
        page.setInputFiles(fileUploadField(label), Paths.get(filePath));
    }

    public void fillStudentRegistrationForm(Map<String, String> data) {

        for (Map.Entry<String, String> entry : data.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();


            if (page.locator(textField(key)).count() > 0) {
                fill(textField(key), value);
            }

            else if (page.locator(radioOrCheckbox(key, value)).count() > 0) {
                page.locator(radioOrCheckbox(key, value)).check();
            }

            else if (page.locator(dropdown(key)).count() > 0) {
                page.selectOption(dropdown(key),value);
            }

            else if (page.locator(fileUploadField(key)).count()>0) {
                fileUpload(key, value);
            }
        }
    }

    public void submit() {
        click("//input[@type='submit']");
    }
}