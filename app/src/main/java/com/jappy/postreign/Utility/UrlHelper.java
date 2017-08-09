package com.jappy.postreign.Utility;


import com.jappy.postreign.BuildConfig;

/**
 * Created by jappy on 08-08-17.
 */

public class UrlHelper {
    private final static String PROD_URL = "https://hn.algolia.com";
    private final static String DEVELOP_URL = "https://hn.algolia.com";

    public static String getBaseUrl() {
        switch (BuildConfig.FLAVOR) {
            case "prod":
                return PROD_URL;
            case "dev":
                return DEVELOP_URL;
            default:
                return DEVELOP_URL;
        }
    }
}
