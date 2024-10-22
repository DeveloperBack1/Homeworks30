package lesson19_Date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class MainLocalDate {
    public static void main(String[] args) {
        LocalDate date3 = LocalDate.of(2024, 10, 12);
        System.out.println(date3);

        // получение элементов из даты
        int year = date3.getYear();
        int month = date3.getMonthValue(); //1...12
        System.out.println(month);
        Month monthEnum = date3.getMonth();
        System.out.println(monthEnum);

        int dayOfMonth = date3.getDayOfMonth(); // номер дня в неделе
        DayOfWeek dayOfWeek = date3.getDayOfWeek(); // день недели как элемент перечисления
        System.out.println(date3);
        System.out.println(dayOfWeek);
        System.out.printf("%d.%d.%d \n", dayOfMonth, month, year);


        LocalDate date1 = LocalDate.of(1996, 1, 1);
        System.out.println(date1);

        System.out.println();
        // добавление или удаление любого элемента даты
        date1 = date1.plusYears(4);
        date1 = date1.plusMonths(3);
        date1 = date1.plusDays(14);
        System.out.println(date1);

        date1 = date1.minusMonths(10);
        date1 = date1.minusDays(3);
        date1 = date1.minus(5, ChronoUnit.DAYS);
        System.out.println(date1);

        // сравнение даты
        System.out.println("isAfter = "+date3.isAfter(date1));
        System.out.println("isBefore = "+date3.isBefore(date1));
        System.out.println("equals = "+date3.equals(date1));
        System.out.println("compareTo = "+date3.compareTo(date1));
        System.out.println("compareTo = "+date1.compareTo(date3));
    }
}
