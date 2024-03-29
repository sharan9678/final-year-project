package com.sharan.controller;

import com.sharan.model.FilesInDirectory;
import com.sharan.service.ComparatorService;
import com.sharan.service.ContractTesterServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.io.IOException;
import java.util.ArrayList;

@RestController
@RequestMapping("/contract-test")
public class ContractTesterController {

//    @GetMapping("/getFile")
//    public ResponseEntity<String> dummy() {
//        String message = "hello from contract testing tool!";
//        return new ResponseEntity<>(message, HttpStatus.OK);
//    }
    @Autowired
    private ContractTesterServices contractTesterServices;
    private ComparatorService comparatorService;

    @CrossOrigin
    @GetMapping("/download-contract")
    public ResponseEntity<String> downloadContract(
            @PathParam("url") String url) {
        String fileUrl = "http://" + url + "/v3/api-docs.yaml";
        String destinationPath = "D:\\final-year-project\\backend\\contractsDB";
        try {
            contractTesterServices.downloadFile(fileUrl, destinationPath, url);
            return new ResponseEntity<>("successfully downloaded the contract!", HttpStatus.OK);
        } catch (IOException exception) {
            return new ResponseEntity<>("failed to download the contract!", HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @GetMapping("/files")
    public ResponseEntity<ArrayList<FilesInDirectory>> filesAvailable() {
        return new ResponseEntity<>(contractTesterServices.getAllFile(), HttpStatus.OK);
    }
}
