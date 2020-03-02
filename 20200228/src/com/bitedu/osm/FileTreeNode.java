package com.bitedu.osm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileTreeNode {
    private String fileName;
    private long totalLength;
    private File file;
    List<FileTreeNode> childrens = new ArrayList<>();

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(long totalLength) {
        this.totalLength = totalLength;
    }

    public List<FileTreeNode> getChildrens() {
        return childrens;
    }

    public void addChildNode(FileTreeNode node) {
        this.childrens .add(node);
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
