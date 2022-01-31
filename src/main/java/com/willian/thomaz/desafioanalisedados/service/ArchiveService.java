package com.willian.thomaz.desafioanalisedados.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ArchiveService {

    public Path getArchive(String directory) {
        return Paths.get(directory);
    }

    public BufferedReader getBufferedReader(Path path) throws IOException {
        return Files.newBufferedReader(path, StandardCharsets.UTF_8);
    }

    public BufferedWriter getBufferedWriter(Path path) throws IOException {
        return Files.newBufferedWriter(path, StandardCharsets.UTF_8);
    }
}