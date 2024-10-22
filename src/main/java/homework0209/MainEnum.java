package homework0209;


public class MainEnum {
    public static void main(String[] args) {
        // Получаем один и тот же экземпляр CoffeeMachineEnum
        CoffeeMachineEnum machine1 = CoffeeMachineEnum.INSTANCE;
        CoffeeMachineEnum machine2 = CoffeeMachineEnum.INSTANCE;
        CoffeeMachineEnum machine3 = CoffeeMachineEnum.INSTANCE;

        // Используем кофейный автомат для приготовления кофе
        System.out.println(machine1.makeCoffee("Espresso"));
        System.out.println(machine2.makeCoffee("Latte"));
        System.out.println(machine3.makeCoffee("Cappuccino"));

        //  обе переменные указывают на один и тот же объект
        System.out.println(machine1 == machine2);// true
        System.out.println(machine1 == machine3);
    }
}