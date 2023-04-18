package com.sharan.utils;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ContractTesterUtilities {

//    public static void main(String[] args) {
//        ContractTesterUtilities contractTesterUtilities = new ContractTesterUtilities();
//        String directoryPath = "/Users/sharan/final-year-project/contractsDB";
//
//        contractTesterUtilities.setFileName(directoryPath, "api-docs");
//    }

    /**
     * file naming utility used to name the downloaded contracts in the DB
     * @param directoryPath
     * pass the directory name to check the existing files in it
     * @param url
     * pass the url so that we can make sure there exist a contract in this
     * name else create a new contract
     * @return
     * name for the file
     */
    public String setFileName(String directoryPath, String url) {
        //get the file name from the url
        String fileName = url + "-old.yaml";

        // check if a file with that name already exist in the directory
        File directory = new File(directoryPath);
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().equals(fileName)) {
                        // return the file name with suffix old
                        return url + "-new.yaml";
                    }
                }
            }
        }
        return url + "-old.yaml";
    }
}
