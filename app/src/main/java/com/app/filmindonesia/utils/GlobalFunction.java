package com.app.filmindonesia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GlobalFunction {

    public static String dateFormater(String oldDate) {
        String newDate = null;
        SimpleDateFormat oldFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date convertedDate;

        try {
            convertedDate = oldFormat.parse(oldDate);
            SimpleDateFormat newFormat = new SimpleDateFormat("MMMM dd, yyyy");
            newDate = newFormat.format(convertedDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}
