package lesson19_Date;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class MainLocalTime {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        System.out.println("Текущее время = "+ localTime);

        LocalTime time = LocalTime.of(10, 30);
        System.out.println("Любое время = "+ time);

        LocalTime time1 = LocalTime.ofSecondOfDay(10_000);
        System.out.println("Любое время = "+ time1);

        //Изменение
        LocalTime time2 = localTime.plusHours(2);
        LocalTime time3 = localTime.minusMinutes(40);
        LocalTime time4 = localTime.plusSeconds(3600);
        LocalTime time5 = localTime.plus(3600, ChronoUnit.MICROS);

        System.out.println(localTime);
        System.out.println(time2);
        System.out.println(time3);
        System.out.println(time4);
    }
}
