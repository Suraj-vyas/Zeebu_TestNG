package com.zeebu.constants;

import com.zeebu.utils.ConfigReader;

import java.io.File;
import java.lang.System;

public final class FrameworkConstants {

    private FrameworkConstants() {
    }


    public static final String PROJECT_PATH=System.getProperty("user.dir") + File.separator;
    public static final String EXCEL_DATA_FILE_PATH = ConfigReader.getProperty("EXCEL_DATA_FILE_PATH");
    public static final String JSON_DATA_FILE_PATH = ConfigReader.getProperty("JSON_DATA_FILE_PATH");
    public static final String CSV_DATA_FILE_PATH = ConfigReader.getProperty("CSV_DATA_FILE_PATH");
    public static final String BROWSER = ConfigReader.getProperty("BROWSER");
    public static final String REPORT_TITLE = ConfigReader.getProperty("REPORT_TITLE");
    public static final String EXTENT_REPORT_NAME = ConfigReader.getProperty("EXTENT_REPORT_NAME");
    public static final String EXTENT_REPORT_FOLDER = ConfigReader.getProperty("EXTENT_REPORT_FOLDER");
    public static final String AUTHOR = ConfigReader.getProperty("AUTHOR");
    public static final String ENVIRONMENT = ConfigReader.getProperty("ENVIRONMENT");
    public static final String RELEASE = ConfigReader.getProperty("RELEASE");
    public static final String PROJECT = ConfigReader.getProperty("PROJECT");
    public static final String TESTCATEGORY = ConfigReader.getProperty("TESTCATEGORY");
    public static final String EXTENT_REPORT_FOLDER_PATH = PROJECT_PATH + EXTENT_REPORT_FOLDER;
    public static final String EXTENT_REPORT_FILE_NAME = EXTENT_REPORT_NAME + ".html";
    public static String EXTENT_REPORT_FILE_PATH = EXTENT_REPORT_FOLDER_PATH + File.separator + EXTENT_REPORT_FILE_NAME;

    public static final String YES = "yes";
    public static final String NO = "no";

    public static final String ICON_OS_WINDOWS = "<i class='fa fa-windows' ></i>";
    public static final String ICON_OS_MAC = "<i class='fa fa-apple' ></i>";
    public static final String ICON_OS_LINUX = "<i class='fa fa-linux' ></i>";

    public static final String ICON_BROWSER_EDGE = "<i class=\"fa fa-edge\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_CHROME = "<i class=\"fa fa-chrome\" aria-hidden=\"true\"></i>";
    public static final String ICON_BROWSER_FIREFOX = "<i class=\"fa fa-firefox\" aria-hidden=\"true\"></i>";

    public static final String APIBaseURL = ConfigReader.getProperty("APIBaseUrl");
    public static final String UIBaseURL = ConfigReader.getProperty("UIBaseUrl");

    public static final int WAIT_PAGE_LOADED = Integer.parseInt(ConfigReader.getProperty("WAIT_PAGE_LOADED"));


}
