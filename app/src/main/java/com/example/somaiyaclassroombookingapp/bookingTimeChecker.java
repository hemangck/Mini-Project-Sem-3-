package com.example.somaiyaclassroombookingapp;
import java.util.Calendar;

public class bookingTimeChecker {

    public static boolean isBookingAllowed() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        // Check if it's Saturday and the time is after 12:00 AM
        if (dayOfWeek == Calendar.SATURDAY && hour >= 0) {
            return true;
        }

        // Check if it's Sunday and the time is before 11:59 PM
        if (dayOfWeek == Calendar.SUNDAY && hour < 23) {
            return true;
        }

        return false;
    }
}
