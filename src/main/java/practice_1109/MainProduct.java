package practice_1109;

public class MainProduct {
    public static void main(String[] args) {
        // Создание корзины для электроники
        Cart<Electronic> electronicsCart = new Cart<>();
        Electronic phone = new Electronic("Smartphone", 699.99);
        Electronic laptop = new Electronic("Laptop", 1299.99);

        electronicsCart.addItem(phone);
        electronicsCart.addItem(laptop);
        electronicsCart.showItems();
        System.out.println("Общая стоимость электроники: $" + electronicsCart.getTotalPrice());

        // Создание корзины для одежды
        Cart<Clothing> clothingCart = new Cart<>();
        Clothing tshirt = new Clothing("T-shirt", 19.99);
        Clothing jeans = new Clothing("Jeans", 49.99);

        clothingCart.addItem(tshirt);
        clothingCart.addItem(jeans);
        clothingCart.showItems();
        System.out.println("Общая стоимость одежды: $" + clothingCart.getTotalPrice());

        // Создание корзины для продуктов
        Cart<Grocery> groceryCart = new Cart<>();
        Grocery apple = new Grocery("Apple", 0.99);
        Grocery milk = new Grocery("Milk", 2.99);

        groceryCart.addItem(apple);
        groceryCart.addItem(milk);
        groceryCart.showItems();
        System.out.println("Общая стоимость продуктов: $" + groceryCart.getTotalPrice());
    }
}
