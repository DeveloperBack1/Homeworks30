package lesson19_Date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println("long: "+date.getTime());

        Date date2 = new Date(3434343766664L);
        System.out.println(date2);

        // Vergleich:
        System.out.println(date.getTime() >= date2.getTime());
        System.out.println(date2.after(date));
        System.out.println(date2.before(date));

       // Aneignung

        Date date3 = new Date();
        date3.setTime(date2.getTime());
        System.out.println(date3);

        // Comparator

        System.out.println(date3.compareTo(date2)); // 0  true
        System.out.println(date3.equals(date));

// Локализация
        Locale locale = new Locale("uk"); //украинская локализация //de, ru, en
        Locale.setDefault(locale);
        Date now = new Date();
        System.out.println(now);
        // Используем стандарные форматеры
        String date4 = String.format(locale, "%tc\n", now) + // длинная строка
            String.format(locale, "%tD\n", now) + //(MM/DD/YY)
            String.format(locale, "%tF\n", now) + //(YYYY-MM-DD)
            String.format(locale, "%tr\n", now) + //Full 12-hour time
            String.format(locale, "%tz\n", now) + //Time zone GMT offset
            String.format(locale, "%tZ\n", now);//Localized time zone abbreviation
        System.out.println(date);

        //Преобразование в строку
        String pattern = "dd.MM.yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        System.out.println("Пользовательский формат -> "+df.format(now));

        //Макс Date
        Date dateMax = new Date(Long.MAX_VALUE);
        System.out.println("Max дата = " + dateMax);
    }
}
