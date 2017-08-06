package com.aqua30.mvpsample.model.util;

import java.text.SimpleDateFormat;

/**
 * Created by Saurabh(aqua) on 05-04-2017.
 */

public class TimeManager {

    /* provide milliseconds and get the date in the format you required */
    public static String getDate_from_millis(Object millis, String dateFormat) {
        long milliseconds;
        SimpleDateFormat dtFormat = new SimpleDateFormat(dateFormat);
        if (millis instanceof String) {
            milliseconds = Long.parseLong(String.valueOf(millis));
        } else {
            milliseconds = (long) millis;
        }
        String formattedDate = dtFormat.format(milliseconds);
        return formattedDate;
    }

}
