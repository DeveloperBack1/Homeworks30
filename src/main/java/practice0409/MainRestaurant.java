package practice0409;

public class MainRestaurant {

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant(100);
        Order order1 = new Order(1,"Alex",DishType.SUSHI,OrderStatus.NEW);
        Order order2 = new Order(2,"Alexa",DishType.BURGER,OrderStatus.NEW);
        restaurant.addOrder(order1);
        restaurant.addOrder(order2);

        System.out.println(Restaurant.totalOrders);
    }


}
