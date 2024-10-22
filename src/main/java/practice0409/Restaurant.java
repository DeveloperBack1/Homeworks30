package practice0409;

public class Restaurant {
    Order[] orders;
    static int totalOrders = 0;

    public Restaurant(int maxCountOrder) {
        orders = new Order[maxCountOrder];
    }

    void addOrder(Order order) {
        orders[totalOrders] = order;
        totalOrders++;
    }
}

