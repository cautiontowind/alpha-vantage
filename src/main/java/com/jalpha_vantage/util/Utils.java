package com.jalpha_vantage.util;

import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;

public class Utils {

    public static final String BASE_URI = "http://www.alphavantage.co/query?";

    public static final String contentKeyVal(String key, String val) throws UnsupportedEncodingException {
        return new StringBuilder().append(key).append("=").append(UriUtils.encode(val, "UTF-8")).toString();
    }
}
