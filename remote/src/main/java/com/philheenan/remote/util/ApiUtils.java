package com.philheenan.remote.util;

import java.io.*;

/**
 * @author Phil Heenan (pjheenan@gmail.com)
 */
public class ApiUtils {

    public static String stringResponse(InputStream response) {
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(response));

        String line;

        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
