package com.zeebu.utils;

import com.zeebu.constants.FrameworkConstants;

import static com.zeebu.constants.FrameworkConstants.BROWSER;

public final class BrowserInfoUtils {

    private BrowserInfoUtils() {
        super();
    }

    private static final String OS = System.getProperty("os.name").toLowerCase();

    public static String getBrowserInfo() {
        return BROWSER;
    }

    public static String getOSInfo() {
        return System.getProperty("os.name");
    }

    public static boolean isWindows() {
        return (OS.contains("win"));
    }

    public static boolean isMac() {
        return (OS.contains("mac"));
    }

    public static boolean isUnix() {
        return (OS.contains("nix") || OS.contains("nux") || OS.contains("aix"));
    }
}
