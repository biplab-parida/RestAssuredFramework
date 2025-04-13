package com.biplab.qa.utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtil {
    public static JsonObject readJsonFile(String filePath) {
        try {
            FileReader reader = new FileReader(filePath);
            JsonObject obj = JsonParser.parseReader(reader).getAsJsonObject();
            return obj;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
