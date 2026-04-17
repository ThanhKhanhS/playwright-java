package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
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
        return String.format("//label[text()='%s']/following::div//label[text()='%s']", label, value);
    }

    private String dropdown(String id) {
        return String.format("//select[@id='%s']", id);
    }

    private String fileUploadField(String label) {
        return String.format("//label[text()='%s']/following-sibling::div//input[@type='file']", label);
    }

    // ===== BUSINESS LOGIC =====

    public void fillForm(Map<String, String> data) {

        for (Map.Entry<String, String> entry : data.entrySet()) {

            String key = entry.getKey();
            String value = entry.getValue();

            // Text fields (input hoặc textarea, loại trừ file)
            if (page.locator(textField(key)).count() > 0) {
                fill(textField(key), value);
            }

            // Radio / Checkbox
            else if (page.locator(radioOrCheckbox(key, value)).count() > 0) {
                click(radioOrCheckbox(key, value));
            }

            // Dropdown - sử dụng selectOption như yêu cầu
            else if (page.locator(dropdown(key)).count() > 0) {
                page.selectOption(dropdown(key),value);
            }
        }
    }

    public void submit() {
        click("//input[@type='submit']");
    }

    // ===== METHOD RIÊNG ĐỂ UPLOAD (theo yêu cầu) =====
    public void uploadFile(String label, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File không tồn tại: " + filePath);
        }

        String xpath = fileUploadField(label);
        if (page.locator(xpath).count() > 0) {
            upload(xpath, filePath);   // tái sử dụng method từ BasePage
        } else {
            throw new RuntimeException("Không tìm thấy trường upload file cho label: " + label);
        }
    }
}