package homework0209_1;


public class MainSeason {
    public static void main(String[] args) {

        Month currentMonth = Month.JANUARY;
        System.out.println("Текущий месяц: " + currentMonth.getRussianName());
        System.out.println("Рекомендованный режим питания: " + currentMonth.getDietRecommendation());
    }
}