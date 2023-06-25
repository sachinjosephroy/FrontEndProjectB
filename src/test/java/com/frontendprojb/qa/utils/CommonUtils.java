package com.frontendprojb.qa.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CommonUtils {
    public static String usingSubstringMethod(String text, int length) {
        if (text.length() <= length) {
            return text;
        } else {
            return text.substring(0, length);
        }
    }

    public static String dateTime() {
        return new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(Calendar.getInstance().getTime());
    }
}