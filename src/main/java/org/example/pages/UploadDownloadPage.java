package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Download;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadPage {
    private final Page page;

    private static final String Upload_Btn   = "//input[@id='%s']";
    private static final String Download_Btn = "//a[normalize-space()='%s']";

    public UploadDownloadPage(Page page){
        this.page = page;
    }

    public void uploadFiles(String uploadId, String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist " + filePath);
        }
        String xpath = String.format(Upload_Btn, uploadId);
        page.setInputFiles(xpath, Paths.get(filePath));
    }

    public Path downloadFile(String inputText, String saveDir) {
        String xpath = String.format(Download_Btn,inputText);
        Download download = page.waitForDownload(() -> {
            page.click(xpath);
        });

        Path savePath = Paths.get(saveDir, download.suggestedFilename());
        download.saveAs(savePath);
        return savePath;
    }
}
