package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.ExpandTestingNavigationPage;
import org.example.pages.KeyPressPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class KeyPressTest extends BaseTest {

    @Test
    public void TC01_pressKeyAndVerifyResult(){
        page.navigate(URLs.Expand_Testing_Home);
        new ExpandTestingNavigationPage(page).navigateTo("Key Presses");

        KeyPressPage keyPressPage = new KeyPressPage(page);

        Map<String, String> testData = new LinkedHashMap<>();
        testData.put("a", "You entered: A");
        testData.put("b", "You entered: B");
        testData.put("Tab", "You entered: TAB");
        testData.put("Escape", "You entered: ESCAPE");

        for (Map.Entry<String, String> entry : testData.entrySet()) {
            String key = entry.getKey();
            String expectMessage = entry.getValue();

            String actualMassage = keyPressPage.pressKeyAndGetResult(key);

            Assert.assertEquals(actualMassage, expectMessage);
        }
    }
}
