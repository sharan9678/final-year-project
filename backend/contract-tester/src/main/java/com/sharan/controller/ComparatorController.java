package com.sharan.controller;

import com.sharan.model.ComparatorResult;
import com.sharan.service.ComparatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.File;
import java.io.FileNotFoundException;

@RestController
@RequestMapping("/comparator")
public class ComparatorController {
    @Autowired
    private ComparatorService comparatorService;

    @GetMapping("/getInHtml")
    public ResponseEntity<ComparatorResult> comparatorResultHtmlResponse(
            @PathParam("contract1") String contract1,
            @PathParam("contract2") String contract2
    ){
        try {
            String contractsDirectoryPath = "D:\\final-year-project\\backend\\contractsDB\\";
            File file1 = new File(contractsDirectoryPath + contract1);
            File file2 = new File(contractsDirectoryPath + contract2);
            if (!file1.exists() || !file2.exists()) {
                throw new FileNotFoundException();
            } else {
                return new ResponseEntity<>(comparatorService.getHtmlRender(file1, file2), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/getInMarkdown")
    public ResponseEntity<ComparatorResult> comparatorResultMarkdownResponse(
            @PathParam("contract1") String contract1,
            @PathParam("contract2") String contract2
    ){
        try {
            String contractsDirectoryPath = "D:\\final-year-project\\backend\\contractsDB\\";
            File file1 = new File(contractsDirectoryPath + contract1);
            File file2 = new File(contractsDirectoryPath + contract2);
            if (!file1.exists() || !file2.exists()) {
                throw new FileNotFoundException();
            } else {
                return new ResponseEntity<>(comparatorService.getMarkdownRender(file1, file2), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @GetMapping("/getInJson")
    public ResponseEntity<ComparatorResult> comparatorResultJsonResponse(
            @PathParam("contract1") String contract1,
            @PathParam("contract2") String contract2
    ){
        try {
            String contractsDirectoryPath = "D:\\final-year-project\\backend\\contractsDB\\";
            File file1 = new File(contractsDirectoryPath + contract1);
            File file2 = new File(contractsDirectoryPath + contract2);
            if (!file1.exists() || !file2.exists()) {
                throw new FileNotFoundException();
            } else {
                return new ResponseEntity<>(comparatorService.getJsonRender(file1, file2), HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
