package org.example.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Download;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadDownloadPage {
    private final Page page;

    private static final String Upload_Btn   = "//input[@id='uploadFile']";
    private static final String Download_Btn = "//a[normalize-space()='Download']";

    public UploadDownloadPage(Page page){
        this.page = page;
    }

    public void uploadFiles(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("File does not exist " + filePath);
        }
        page.setInputFiles(Upload_Btn, Paths.get(filePath));
    }

    public Path downloadFile(String saveDir) {
        Download download = page.waitForDownload(() -> {
            page.click(Download_Btn);
        });

        Path savePath = Paths.get(saveDir, download.suggestedFilename());
        download.saveAs(savePath);
        return savePath;
    }
}
