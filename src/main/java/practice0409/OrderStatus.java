package practice0409;

public enum OrderStatus {
    NEW,COOKING,READY,DELIVERED;

    boolean canChange(OrderStatus status) {
        return !OrderStatus.DELIVERED.equals(status);
    }

}
