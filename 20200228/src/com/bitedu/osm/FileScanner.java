package com.bitedu.osm;

import java.io.File;

public class FileScanner {
    public static void scannerDirectory(FileTreeNode node) {
        File[] files = node.getFile().listFiles();
        if (files == null) {
            return;
        }
        for (File file : files) {
            FileTreeNode child = new FileTreeNode();
            child.setFile(file);
            child.setFileName(file.getName());
            if (file.isDirectory()) {
                scannerDirectory(child);
            } else {
                child.setTotalLength(file.length());
            }
            node.setTotalLength(node.getTotalLength() + child.getTotalLength());
            node.addChildNode(child);

        }
    }
}
