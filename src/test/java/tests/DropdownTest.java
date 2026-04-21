package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.DropdownPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

import java.lang.reflect.Array;

public class DropdownTest extends BaseTest {
    private DropdownPage dropdownPage;

    @BeforeMethod
    public void setupTest(){
        page.navigate(URLs.DROPDOWN);
        dropdownPage = new DropdownPage(page);
    }

    @Test
    public void TC01_selectMultipleOptions(){
        String inputId = "demo-multiple-select-input";
        List<String> items = Arrays.asList("Books","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools");
        dropdownPage.selectMultipleOptions(inputId,items);
    }

    @Test
    public void TC02_selectSelectOne(){
        String selectId = "inputGroupSelect03";
        dropdownPage.selectOneOption(selectId, "Mr.");
    }

}
