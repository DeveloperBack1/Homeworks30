package homework0209;


public class CoffeeMachine {
    // Единственный экземпляр класса
    private static CoffeeMachine instance;

    // Приватный конструктор
    private CoffeeMachine() {

    }

    // статический метод для получения единственного экземпляра класса
    public static CoffeeMachine getInstance() {
        if (instance == null) {
            instance = new CoffeeMachine();
        }
        return instance;
    }

    // Метод для приготовления кофе
    public String makeCoffee(String coffeeType) {
        switch (coffeeType.toLowerCase()) {
            case "espresso":
                return "Making Espresso...";
            case "americano":
                return "Making Americano...";
            case "cappuccino":
                return "Making Cappuccino...";
            case "latte":
                return "Making Latte...";
            default:
                return "Sorry, we don't serve " + coffeeType;
        }
    }
}
