package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.DropdownPage;
import org.example.pages.NavigationPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

import java.lang.reflect.Array;

public class DropdownTest extends BaseTest {
    private DropdownPage dropdownPage;

    @Test
    public void TC01_selectMultipleOptions(){
        page.navigate(URLs.Home_Page);
        NavigationPage navigationPage = new NavigationPage(page);
        navigationPage.navigateTo("Widgets", "Select Menu");

        dropdownPage = new DropdownPage(page);
        String inputId = "demo-multiple-select-input";
        List<String> items = Arrays.asList("Books","Movies, Music & Games","Electronics & Computers","Home, Garden & Tools");
        dropdownPage.selectMultipleOptions(inputId,items);
    }

    @Test
    public void TC02_selectSelectOne(){
        page.navigate(URLs.Home_Page);
        NavigationPage navigationPage = new NavigationPage(page);
        navigationPage.navigateTo("Widgets", "Select Menu");

        dropdownPage = new DropdownPage(page);
        String selectId = "inputGroupSelect03";
        dropdownPage.selectOneOption(selectId, "Mr.");
    }

}
