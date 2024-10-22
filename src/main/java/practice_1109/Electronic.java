package practice_1109;

public class Electronic implements Product{

    String name;
    double price;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public Electronic(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Electronic{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
