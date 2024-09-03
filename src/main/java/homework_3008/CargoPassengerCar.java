package homework_3008;
class CargoPassengerCar extends Auto implements PassengerTransportable, CargoTransportable {

    private int maxPassengers;
    private double maxCargoWeight;

    public CargoPassengerCar(String brand, String model, int year, int maxPassengers, double maxCargoWeight) {
        super(brand, model, year);
        this.maxPassengers = maxPassengers;
        this.maxCargoWeight = maxCargoWeight;
    }

    @Override
    public void transportPassengers(int passengers) {
        if (passengers <= maxPassengers) {
            System.out.println("Перевозка " + passengers + " пассажиров.");
        } else {
            System.out.println("Слишком много пассажиров. Максимум: " + maxPassengers);
        }
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



