package calendar.utils;

import java.util.List;

/**
 * Created by employee on 11/2/16.
 */
public class CalendarUtils {

    static final String TYPICAL_STRING_FORMAT = "%4s";
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    static final int DAYS_IN_WEEK = 7;
    protected static final int MAX_WEEKS = 6;


    public static boolean isWeekend(int dayOfWeek, List weekends){
        return weekends.contains(dayOfWeek);
    }

    public static String toWeekendConsoleColor(String value){
        return ANSI_RED + value + ANSI_RESET;
    }

    public static String toThisDayColor(String value){
        return ANSI_CYAN + value + ANSI_RESET;
    }

     public static String toAnotherMonthColor(String value){
        return ANSI_YELLOW + value + ANSI_RESET;
    }

    static int nextDay(int value) {
        return value == 7 ? 1 : ++value;
    }

    public static int backDay(int value) {
        return value == 1 ? 7 : --value;
    }

    public static String getFormattedDay(String numberDay) {
        return String.format(CalendarUtils.TYPICAL_STRING_FORMAT, numberDay);
    }
}
