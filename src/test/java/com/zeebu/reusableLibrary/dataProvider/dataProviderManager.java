package com.zeebu.reusableLibrary.dataProvider;

import org.testng.annotations.DataProvider;
import java.io.IOException;
import java.util.Map;
import java.util.List;
import com.zeebu.utils.ExcelUtils;
import com.zeebu.utils.CSVUtils;
import com.zeebu.utils.JsonUtils;
import static com.zeebu.constants.FrameworkConstants.*;

public class dataProviderManager {

    @DataProvider(name = "excelLoginData")
    public static Object[][] getExcelLoginData() throws IOException {
        String filePath = EXCEL_DATA_FILE_PATH;
        String sheetName = "LoginData";
        return ExcelUtils.getExcelData(filePath, sheetName);
    }

    @DataProvider(name = "csvLoginData")
    public static Object[][] getCsvLoginData() throws IOException {
        String filePath = CSV_DATA_FILE_PATH;
        return CSVUtils.getCSVData(filePath);
    }

    @DataProvider(name = "jsonDataProvider")
    public static Object[][] jsonDataProvider() throws IOException {
        String fileName = JSON_DATA_FILE_PATH;
        List<Map<String, Object>> testData = JsonUtils.getJsonData(fileName);
        return JsonUtils.convertListToObjectArray(testData);
    }
}
