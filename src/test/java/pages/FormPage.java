package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.util.Locale;

public class FormPage {
    private Page page;

    public FormPage(Page page) {
        this.page = page;
    }

    public void navigate() {
        page.navigate("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }

    public void fillForm() {
        page.locator("//label[text()='Name:']/following-sibling::div/input").fill("Khanh");
        page.locator("//label[text()='Email:']/following-sibling::div/input").fill("test@gmail.com");
        page.locator("//input[@id='gender']").check();
        page.locator("//label[text()='Mobile(10 Digits):']/following-sibling::div/input").fill("0123456789");

        page.locator("//label[text()='Date of Birth:']/following-sibling::div/input").fill("1998-10-10");

        page.locator("//label[text()='Subjects:']/following-sibling::div/input").fill("Math");

        Locator checkboxes = page.locator("(//input[@type='checkbox'])");
        for (int i = 0; i < checkboxes.count(); i++) {
            checkboxes.nth(i).check();
        }

        page.locator("//input[@id='picture']").setInputFiles(Paths.get("C:/Users/khanh/OneDrive/Pictures/Screenshots 1/anh.png"));

        page.locator("//textarea[@id='picture']").fill("12 Science Avenue");

        page.locator("//select[@id='state']").selectOption("NCR");

        page.locator("//select[@id='city']").selectOption("Agra");
    }

    public void submit() {
        page.locator("//input[@value='Login']").click();
    }
}