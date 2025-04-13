package com.biplab.qa.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StringUtil {
    public static String readFile(String filePath) {
        try {
            String str = Files.readString(Paths.get(filePath));
            return str;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
