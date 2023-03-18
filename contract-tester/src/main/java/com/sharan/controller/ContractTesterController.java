package com.sharan.controller;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("contract-tester")
public class ContractTesterController {
    @GetMapping
    public String getAllMethods() {
        return "Hello from API side";
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(
            @RequestParam("file") MultipartFile file
    ) {
        try {
            String fileName = file.getOriginalFilename();
            File localFile = new File("~/github/dummyservices/db");
            file.transferTo(localFile);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload file!");
        }
    }

    @GetMapping("/get-api-docs")
    public ResponseEntity<String> getApiDocs(
            @RequestParam("url") String url
    ) {
        try {
            String modUrl = url + "/apiD";
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept((List<MediaType>) MediaType.APPLICATION_OCTET_STREAM);
            ResponseEntity<byte[]> response = restTemplate.getForEntity(url, byte[].class);
            byte[] content = response.getBody();
            String filename = "myfile.txt" + Math.random() * 100;
            File file = new File(filename);
            FileCopyUtils.copy(content, file);
            FileSystemResource resource = new FileSystemResource(file);
            return new ResponseEntity<String>(
                    "File downloaded and stored at: " + resource.getFile().getAbsolutePath(),
                    HttpStatus.OK
            );
        } catch (IOException e) {
            return new ResponseEntity<String>(
                    "Failed to download the API doc file: " + e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
}
