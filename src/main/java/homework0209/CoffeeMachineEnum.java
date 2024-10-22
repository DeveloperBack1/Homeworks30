package homework0209;


public enum CoffeeMachineEnum {
    INSTANCE;

    // Конструктор по умолчанию является приватным

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