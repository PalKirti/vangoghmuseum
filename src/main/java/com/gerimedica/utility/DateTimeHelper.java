package com.gerimedica.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeHelper {

    /**
     * to get currentDate time in format _yyyy-MM-dd_HH-mm-ss
     *
     * @return currentDate time in format _yyyy-MM-dd_HH-mm-ss
     */
    public static String getCurrentDateTime() {

        DateFormat dateFormat = new SimpleDateFormat("_yyyy-MM-dd_HH-mm-ss");
        Calendar cal = Calendar.getInstance();
        String time = "" + dateFormat.format(cal.getTime());

        System.out.println("time is:" + time);
        return time;
    }

    /**
     * get only Date in format _yyyy-MM-dd from getCurrentDateTime method
     *
     * @return Date in format _yyyy-MM-dd
     */
    public static String getCurrentDate() {
        System.out.println("time substring val is:" + getCurrentDateTime().substring(0, 11));
        return getCurrentDateTime().substring(0, 11);
    }

}
