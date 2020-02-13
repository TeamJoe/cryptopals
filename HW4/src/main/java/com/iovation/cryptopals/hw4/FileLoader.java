package com.iovation.cryptopals.hw4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class FileLoader {
    public static String getFile(String resource) throws IOException {
        var stream = FileLoader.class.getClassLoader().getResourceAsStream(resource);

        return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
    }

    public static String[] getLines(String resource) throws IOException {
        return getFile(resource).split("\n");
    }
}
