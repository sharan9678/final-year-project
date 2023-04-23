package com.sharan.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FilesInDirectory {
    private String directoryName;
    private ArrayList<String> files;

    public FilesInDirectory() {
    }

    public FilesInDirectory(String directoryName, ArrayList<String> files) {
        this.directoryName = directoryName;
        this.files = files;
    }

    @Override
    public String toString() {
        return "FilesInDirectory{" +
                "directoryName='" + directoryName + '\'' +
                ", files=" + files +
                '}';
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public ArrayList<String> getFiles() {
        return files;
    }

    public void setFiles(ArrayList<String> files) {
        this.files = files;
    }
}
