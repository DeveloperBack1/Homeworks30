package homework1110;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ex1 {
    public static void main(String[] args) {
        //  возраст человека:
        calculateAge(LocalDate.of(1985, 1, 10));
        //  Сколько времени осталось до работы или если вы проспали
        timeUntilWork();
        //  Время в Pacific/Midway:
        printPacificMidwayTime();
        //  Дата минус 10 лет:
        subtractYearsFromDate();
        //  "10 Января 1985" – пятница, и получить день недели для другой даты:
        checkDayOfWeek();
        //  Создать дату своего рождения и вывести в формате "10 Января 1985":
        printBirthDate();
        //  Форматированная дата:
        printCustomFormattedDate();
        //  Дата для Индии:
        printLocalizedDateForIndia();
        //  Проверка года на високосность:
        System.out.println(isLeapYear(1985));

    }

//    Проверка года на високосность:

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

//  Вывести локализованную дату для Индии:

    public static void printLocalizedDateForIndia() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("hi", "IN"));
        String formattedDate = today.format(formatter);
        System.out.println("Дата для Индии: " + formattedDate);
    }

 //   Вывести дату в формате 19-12-22, 19, 353, 11:47:



    public static void printCustomFormattedDate() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy, dd, D, HH:mm");
        String formattedDate = now.format(formatter);
        System.out.println("Форматированная дата: " + formattedDate);
    }

 //    Создать дату своего рождения и вывести в формате "10 Января 1985":


    public static void printBirthDate() {
        LocalDate birthDate = LocalDate.of(1985, 1, 10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
        System.out.println("Дата рождения: " + birthDate.format(formatter));
    }

 //    Проверить, что "10 Января 1985" – пятница, и получить день недели для другой даты:

    public static void checkDayOfWeek() {
        LocalDate birthDate = LocalDate.of(1985, 1, 10);
        DayOfWeek dayOfWeek = birthDate.getDayOfWeek();
        System.out.println("10 января 1985: " + dayOfWeek);

        // Проверка любой другой даты
        LocalDate someDate = LocalDate.of(2024, 10, 11);
        System.out.println("11 октября 2024: " + someDate.getDayOfWeek());
    }

 //  Вычесть 10 лет из созданной даты и вывести на консоль:

    public static void subtractYearsFromDate() {
        LocalDate birthDate = LocalDate.of(1985, 1, 10);
        LocalDate newDate = birthDate.minusYears(10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru"));
        System.out.println("Дата минус 10 лет: " + newDate.format(formatter));
    }

 //   Получить ZonedDateTime для зоны "Pacific/Midway" и вывести на консоль:


    public static void printPacificMidwayTime() {
        ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("Pacific/Midway"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMMM yyyy HH:mm:ss z");
        System.out.println("Время в Pacific/Midway: " + zdt.format(formatter));
    }

 //   Получить возраст человека на текущий момент, если известна дата рождения:

    public static void calculateAge(LocalDate birthDate) {
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthDate, today);
        System.out.println("Возраст: " + age.getYears() + " лет, " + age.getMonths() + " месяцев, " + age.getDays() + " дней.");
    }

 //    Сколько времени осталось до работы или если вы проспали, то на сколько:

    public static void timeUntilWork() {
        LocalTime now = LocalTime.now();
        LocalTime workStart = LocalTime.of(9, 0);

        if (now.isBefore(workStart)) {
            Duration timeUntilWork = Duration.between(now, workStart);
            System.out.println("Времени до начала работы: " + timeUntilWork.toHoursPart() + " часов "
                + timeUntilWork.toMinutesPart() + " минут.");
        } else {
            Duration timeLate = Duration.between(workStart, now);
            System.out.println("Вы проспали на: " + timeLate.toHoursPart() + " часов "
                + timeLate.toMinutesPart() + " минут.");
        }
    }



}
