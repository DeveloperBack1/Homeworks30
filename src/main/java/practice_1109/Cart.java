package practice_1109;
import java.util.ArrayList;
import java.util.List;

public class Cart<T extends Product> {
    private List<T> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    // Добавление товара в корзину
    public void addItem(T item) {
        items.add(item);
        System.out.println(item.getName() + " добавлен в корзину.");
    }

    // Удаление товара из корзины
    public void removeItem(T item) {
        items.remove(item);
        System.out.println(item.getName() + " удален из корзины.");
    }

    // Получение суммы всех товаров в корзине
    public double getTotalPrice() {
        double total = 0;
        for (T item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Вывод всех товаров в корзине
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Товары в корзине:");
            for (T item : items) {
                System.out.println(item.getName() + " - $" + item.getPrice());
            }
        }
    }
}

