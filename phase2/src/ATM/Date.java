package ATM;

import java.time.LocalDate;
import java.time.Month;

/**
 * Handles the date for the program.
 */
public class Date {
    private static LocalDate date;

    public static LocalDate getDate(){
        return date;
    }

    /**
     * Sets the date. If no date is given it sets the default date as Jan 1, 2019
     * @param newDate
     */
    public static void setDate(LocalDate newDate){
        if (newDate == null){
            date = LocalDate.of(2019,1,1);
        } else {
            date = newDate;
        }
    }

    public static Month getMonth(){
        return date.getMonth();
    }

    public static Month[] monthList(){
        return Month.values();
    }

    public static int getYear(){
        return date.getYear();
    }

    public static int getDay(){
        return date.getDayOfMonth();
    }

    static LocalDate nextDay(int numberOfDays){
        return date.plusDays(numberOfDays);
    }

    /**
     * Determines if a month has ended.
     * @return Whether it's the first the a month.
     */
    static boolean isNewMonth(){
        return (date.getDayOfMonth() == 1);
    }
}
