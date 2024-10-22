package practice0409;

public class Order {

    private  int id;
    private  String nameOfClient;
    private  DishType dishType;
    private OrderStatus orderStatus;

    public Order(int id,String nameOfClient, DishType dishType, OrderStatus orderStatus) {
        this.id = id;
        this.nameOfClient = nameOfClient;
        this.dishType = dishType;
        this.orderStatus = OrderStatus.NEW;
    }

    public int getId() {
        return id;
    }

    public String getNameOfClient() {
        return nameOfClient;
    }

    public DishType getDishType() {
        return dishType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", nameOfClient='" + nameOfClient + '\'' +
            ", dishType=" + dishType +
            ", orderStatus=" + orderStatus +
            '}';
    }

    void changeStatus(OrderStatus newStatus) {
        if(newStatus == OrderStatus.NEW) {
            orderStatus = OrderStatus.NEW;
        } else {
            orderStatus = newStatus;
        }

    }
}
