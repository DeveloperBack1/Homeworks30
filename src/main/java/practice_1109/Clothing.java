package practice_1109;

public class Clothing implements Product{

    String name;
    double price;

    @Override
    public String getName() {
        return "";
    }

    @Override
    public double getPrice() {
        return 0;
    }

    public Clothing(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Clothing{" +
            "name='" + name + '\'' +
            ", price=" + price +
            '}';
    }
}
