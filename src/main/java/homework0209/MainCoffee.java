package homework0209;

public class MainCoffee {
    public static void main(String[] args) {
        // Получаем один и тот же экземпляр CoffeeMachine
        CoffeeMachine machine1 = CoffeeMachine.getInstance();
        CoffeeMachine machine2 = CoffeeMachine.getInstance();
        CoffeeMachine machine3 = CoffeeMachine.getInstance();

        // Используем кофейный автомат для приготовления кофе
        System.out.println(machine1.makeCoffee("Espresso"));
        System.out.println(machine2.makeCoffee("Latte"));
        System.out.println(machine3.makeCoffee("Americano"));

        // Проверка, что обе переменные указывают на один и тот же объект
        System.out.println(machine1 == machine2);  // true
    }
}