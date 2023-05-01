package com.sharan.service;

import com.sharan.model.FilesInDirectory;
import com.sharan.utils.ContractTesterUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;

@Service
public class ContractTesterServices {
    @Autowired
    private ContractTesterUtilities contractTesterUtilities;

    public void downloadFile(String fileUrl,
                             String destinationDirectory,
                             String name) throws IOException {
        URL url = new URL(fileUrl);
        Resource resource = new UrlResource(url);
        if (resource.exists() && resource.isReadable()) {
            String fileName = contractTesterUtilities.setFileName(destinationDirectory, name);
            File destination = new File(destinationDirectory, fileName);
            if (!destination.getParentFile().exists()) {
                destination.getParentFile().mkdirs();
            }
            Files.copy(resource.getInputStream(), destination.toPath());
            System.out.println();
        } else {
            throw new RuntimeException("failed to download file from: " + fileUrl);
        }
    }

    public FilesInDirectory getAllFile() {
        FilesInDirectory filesInDirectory = new FilesInDirectory();
        String directoryPath = "/Users/sharan/final-year-project/backend/contractsDB";
        File directory = new File(directoryPath);
        File[] files = directory.listFiles();
        // set the directory name
        filesInDirectory.setDirectoryName(directory.getName());
        // get the file names in the directory
        ArrayList<String> fileNames = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileNames.add(file.getName());
                }
            }
        }
        filesInDirectory.setFiles(fileNames);
        return filesInDirectory;
    }
}
