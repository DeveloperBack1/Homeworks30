package homework_3008;


class Truck extends Auto implements CargoTransportable {
    private double maxCargoWeight;

    public Truck(String brand, String model, int year, double maxCargoWeight) {
        super(brand, model, year);
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public void transportCargo(double cargoWeight) {
        if (cargoWeight <= maxCargoWeight) {
            System.out.println("Перевозка груза весом " + cargoWeight + " кг.");
        } else {
            System.out.println("Слишком тяжелый груз. Максимум: " + maxCargoWeight + " кг.");
        }
    }


}