package com.sharan.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class FilesInDirectory {
    private String directoryName;
    private String file;

    public FilesInDirectory() {
    }

    public FilesInDirectory(String directoryName,String file) {
        this.directoryName = directoryName;
        this.file = file;
    }

    @Override
    public String toString() {
        return "FilesInDirectory{" +
                "directoryName='" + directoryName + '\'' +
                ", files=" + file +
                '}';
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getFiles() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
