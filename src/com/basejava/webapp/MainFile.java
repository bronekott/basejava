package com.basejava.webapp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) throws IOException {
        File file = new File(".\\.gitignore");
        try {
            System.out.println(file.getCanonicalFile());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        File dir = new File("./src/com/basejava/webapp");
        System.out.println(dir.isDirectory());
        String[] list = dir.list();
        if (list != null) {
            for (String name : Objects.requireNonNull(dir.list())) {
                System.out.println(name);
            }
        }
        try (FileInputStream fis = new FileInputStream(file)) {
            System.out.println(fis.read());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }

        scanPrintDirectory(dir);
    }

    public static void scanPrintDirectory(File directory) {
        //File directory = new File(path);
        String[] list = directory.list();
        if (list != null) {
            for (File file : Objects.requireNonNull(directory.listFiles())) {
                if (file.isDirectory()) {
                    System.out.println("+Directory name: " + file.getName());
                    scanPrintDirectory(file);
                } else if (file.isFile()){
                    System.out.println(" - " + file.getName());
                }
            }
        }

    }
}
