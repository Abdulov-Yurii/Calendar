package calendar.printing;

import calendar.console.ConsoleCalendar;
import calendar.interfaces.Calendar;
import calendar.web.WebCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yurik on 01.09.16.
 */
public class PrintDefaultCalendar {

    public PrintDefaultCalendar(){
        List<Integer> weekends = Arrays.asList(DayOfWeek.SATURDAY.getValue(), DayOfWeek.SUNDAY.getValue());
        int startWithDefaultDay = DayOfWeek.MONDAY.getValue();

        Calendar calendar = null;
        System.out.println("Enter print mode, 1-Console, 2-WEB page");
        switch (new Scanner(System.in).nextInt()) {
            case 1:
                calendar = new ConsoleCalendar();
                break;
            case 2:
                calendar = new WebCalendar();
                break;
        }
        if (calendar != null){
            calendar.print(startWithDefaultDay, LocalDate.now(), weekends);
        }
    }

}