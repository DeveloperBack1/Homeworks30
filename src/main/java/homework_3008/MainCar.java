package homework_3008;


public class MainCar {
    public static void main(String[] args) {

        CargoPassengerCar cargoPassengerCar = new CargoPassengerCar("Mercedes", "Transit",
                2021, 5, 1200.0);

        cargoPassengerCar.startEngine();
        cargoPassengerCar.transportPassengers(4);
        cargoPassengerCar.transportCargo(800.0);
        cargoPassengerCar.stopEngine();
    }
}
