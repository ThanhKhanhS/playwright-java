package tests;

import constants.URLs;
import org.example.base.BaseTest;
import org.example.pages.NavigationPage;
import org.example.pages.UploadDownloadPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.nio.file.Path;

public class UploadDownloadTest extends BaseTest {
    private static final String Download_dir = System.getProperty("user.dir") + File.separator + "src/test/java/resources/download";

    @Test
    public void TC01_uploadFile(){
        page.navigate(URLs.Home_Page);
        NavigationPage navigationPage = new NavigationPage(page);
        navigationPage.navigateTo("Elements", "Upload and Download");
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(page);
        String filePath = System.getProperty("user.dir") + File.separator + "src/test/java/resources/testdata/anh.png";
        uploadDownloadPage.uploadFiles("uploadFile",filePath);
    }

    @Test
    public void TC02_downloadFile(){
        page.navigate(URLs.Home_Page);
        NavigationPage navigationPage = new NavigationPage(page);
        navigationPage.navigateTo("Elements", "Upload and Download");
        UploadDownloadPage uploadDownloadPage = new UploadDownloadPage(page);

        Path downloadedFile = uploadDownloadPage.downloadFile("Download",Download_dir);

        File file = downloadedFile.toFile();
        Assert.assertTrue(file.exists());

    }
}
