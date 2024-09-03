package homework0209_1;


enum Month {
    JANUARY("Январь", Season.WINTER),
    FEBRUARY("Февраль", Season.WINTER),
    MARCH("Март", Season.SPRING),
    APRIL("Апрель", Season.SPRING),
    MAY("Май", Season.SPRING),
    JUNE("Июнь", Season.SUMMER),
    JULY("Июль", Season.SUMMER),
    AUGUST("Август", Season.SUMMER),
    SEPTEMBER("Сентябрь", Season.AUTUMN),
    OCTOBER("Октябрь", Season.AUTUMN),
    NOVEMBER("Ноябрь", Season.AUTUMN),
    DECEMBER("Декабрь", Season.WINTER);

    private String russianName;
    private Season season;

    Month(String russianName, Season season) {
        this.russianName = russianName;
        this.season = season;
    }

    public String getRussianName() {
        return russianName;
    }

    public Season getSeason() {
        return season;
    }

    public String getDietRecommendation() {
        switch (this.season) {
            case WINTER:
                return "Потребляйте больше калорийных продуктов, таких как супы," +
                    " тушеные блюда и горячие напитки.";
            case SPRING:
                return "Добавьте в рацион больше свежих овощей и зелени." +
                    " Легкие салаты и блюда из свежих продуктов будут полезны.";
            case SUMMER:
                return "Употребляйте больше легких и освежающих блюд, таких как " +
                    "салаты, фрукты и холодные напитки.";
            case AUTUMN:
                return "Обратите внимание на сезонные продукты, такие как тыква " ;

            default:
                return "Режим питания не определен.";
        }
    }
}
