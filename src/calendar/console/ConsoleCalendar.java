package calendar.console;

import calendar.interfaces.Calendar;
import calendar.utils.CalendarUtils;
import calendar.utils.WeekdaysValues;
import calendar.utils.WeekdaysName;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by yurik on 05.11.16.
 */
public class ConsoleCalendar implements Calendar {

    private static LocalDate thisDate;
    private static List<Integer> weekends;

    @Override
    public void print(int startWithCustomDay, LocalDate currentDate, List<Integer> listWeekends) {
        weekends = listWeekends;
        parseDate(startWithCustomDay, currentDate);
    }

    private void parseDate(int startWithCustomDay, LocalDate date) {
        thisDate = LocalDate.of(date.getYear(),
                date.getMonth().getValue(), 1);

        System.out.println(generateView(date.getDayOfMonth(), startWithCustomDay));
    }

    private String generateView(int currentDay,
                                int startWeekendOfDay) {
        StringBuilder view = new StringBuilder();
        view.append(getWeekNames(startWeekendOfDay));
        view.append("\n");
        view.append(getMonthValues(startWeekendOfDay, currentDay));
        return view.toString();
    }

    private String getMonthValues(int startWeekendOfDay, int currentDay) {
        DayOfWeek dayOfWeek = thisDate.getDayOfWeek();
        return new StringBuilder()
                .append(WeekdaysValues.getPreviousMonthDays(thisDate, startWeekendOfDay, CalendarUtils.CONSOLE_VIEW))
                .append(WeekdaysValues.getMonthValues(thisDate, currentDay, dayOfWeek, weekends,
                        startWeekendOfDay, CalendarUtils.CONSOLE_VIEW))
                .append(WeekdaysValues.getNextMonthDays(startWeekendOfDay, CalendarUtils.CONSOLE_VIEW))
                .toString();
    }

    private String getWeekNames(int startWeekendOfDay) {
        StringBuilder builder = new StringBuilder();
        for (DayOfWeek dayOfWeek : WeekdaysName.getWeekdays(startWeekendOfDay)) {
            String dayName = CalendarUtils.getFormattedDay(WeekdaysName.getDayValue(dayOfWeek));
            builder.append(dayName);
        }
        return builder.toString();
    }
}
