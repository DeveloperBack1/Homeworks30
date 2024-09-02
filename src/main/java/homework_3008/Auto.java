package homework_3008;
/*
.У нас есть общий класс предок Авто, который инкапсулирует общее состояние и поведение,
 а также его наследники ЛегковойАвтомобиль (может перевозить определенное количество пассажиров)
  и ГрузовойАвтомобиль (может перевозить определенное количество груза).
  Нам нужно создать грузопассажирский  автомобиль,
 который может как перевозить груз так и пассажиров. Как Вы можете сделать это в Java?
 */

class Auto {
    private String brand;
    private String model;
    private int year;

    public Auto(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // Общие методы для всех автомобилей
    public void startEngine() {
        System.out.println("Двигатель заведен.");
    }

    public void stopEngine() {
        System.out.println("Двигатель выключен.");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

