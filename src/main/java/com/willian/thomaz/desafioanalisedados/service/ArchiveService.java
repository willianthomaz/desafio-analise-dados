package com.willian.thomaz.desafioanalisedados.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ArchiveService {

    public Path getArchive(String directory) {
        return Paths.get(directory);
    }

    public List<String> getLines(BufferedReader bufferedReader) {
        return bufferedReader.lines().collect(Collectors.toList());
    }

    public BufferedReader getBufferedReader(Path path) throws IOException {
        return Files.newBufferedReader(path, StandardCharsets.UTF_8);
    }
}
