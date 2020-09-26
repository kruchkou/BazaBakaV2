package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {

    public static String getDate(String date) {
        String resultDate = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date day = df.parse(date);
            resultDate = df.format(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    public static String dateByApp(String date) {
        String resultDate = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat monthAndDay = new SimpleDateFormat("MM-dd");
        DateFormat weekDay = new SimpleDateFormat("E");
        try {
            Date day = df.parse(date);
            resultDate = monthAndDay.format(day) + " " + weekDay.format(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return resultDate;
    }

    public static String getCurrentDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(new Date());
    }
}
