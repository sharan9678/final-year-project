package com.sharan.service;

import com.sharan.model.FilesInDirectory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
public class ContractTesterServices {
    public void downloadFile(String fileUrl,
                                    String destinationDirectory) throws IOException {
        URL url = new URL(fileUrl);
        Resource resource = new UrlResource(url);
        if (resource.exists() && resource.isReadable()) {
            String fileName = Paths.get(url.getPath()).getFileName().toString();
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
        String directoryPath = "/Users/sharan/final-year-project/contractsDB";
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
