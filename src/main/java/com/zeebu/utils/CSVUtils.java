// src/test/java/com/yourcompany/utils/CSVUtils.java

package com.zeebu.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVUtils {

    //Retrieves the CSV Data
    public static Object[][] getCSVData(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        ArrayList<Object[]> dataList = new ArrayList<>();
        // Assuming first line is header
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            dataList.add(fields);
        }
        br.close();
        Object[][] data = new Object[dataList.size()][];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        return data;
    }
}
