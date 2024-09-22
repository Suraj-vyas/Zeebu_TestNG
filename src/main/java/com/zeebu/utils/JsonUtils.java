package com.zeebu.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class JsonUtils {

    /**
     * Reads a JSON file from the resources folder and converts it into a List of Maps.
     *
     * @param fileName  The name of the JSON file (e.g., "testData.json").
     * @return          A List of Maps representing the JSON data.
     * @throws IOException If the file is not found or cannot be read.
     */
    public static List<Map<String, Object>> getJsonData(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = JsonUtils.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("File not found: " + fileName);
        }
        File file = new File(resource.getFile());
        return objectMapper.readValue(file, new TypeReference<List<Map<String, Object>>>(){});
    }

    /**
     * Converts List of Maps into Object[][] for TestNG DataProvider.
     *
     * @param list The list obtained from JSON.
     * @return     Object[][] array for DataProvider.
     */
    public static Object[][] convertListToObjectArray(List<Map<String, Object>> list) {
        Object[][] data = new Object[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            Map<String, Object> map = list.get(i);
            data[i] = new Object[] { map };
        }
        return data;
    }
}
