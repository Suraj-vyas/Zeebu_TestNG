// src/test/java/com/yourcompany/dataproviders/LoginDataProvider.java

package com.zeebu.dataProvider;

import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import com.zeebu.utils.ExcelUtils;
import com.zeebu.utils.CSVUtils;
import com.zeebu.utils.JsonUtils;

public class dataProviderManager {

    @DataProvider(name = "excelLoginData")
    public static Object[][] getExcelLoginData() throws IOException {
        String filePath = "src/test/resources/testData.xlsx";
        String sheetName = "LoginData";
        return ExcelUtils.getExcelData(filePath, sheetName);
    }

    @DataProvider(name = "csvLoginData")
    public static Object[][] getCsvLoginData() throws IOException {
        String filePath = "src/test/resources/testData.csv";
        return CSVUtils.getCSVData(filePath);
    }

    @DataProvider(name = "jsonDataProvider")
    public static Object[][] jsonDataProvider() throws IOException {
        String fileName = "testData.json"; // Ensure this matches your JSON file name
        List<Map<String, Object>> testData = JsonUtils.getJsonData(fileName);
        return JsonUtils.convertListToObjectArray(testData);
    }

    // Add more DataProviders as needed
}
