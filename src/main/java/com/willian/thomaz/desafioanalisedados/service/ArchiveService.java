package com.willian.thomaz.desafioanalisedados.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class ArchiveService {

    public File getArchive(String path) {
        return new File(path);
    }

    public FileReader getFileReader(File file) {
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileReader;
    }

    public BufferedReader getBufferedReader(FileReader fileReader) {
        return new BufferedReader(fileReader);
    }

}
