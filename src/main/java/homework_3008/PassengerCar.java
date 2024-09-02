package homework_3008;


class PassengerCar extends Auto implements PassengerTransportable {
    private int maxPassengers;

    public PassengerCar(String brand, String model, int year, int maxPassengers) {
        super(brand, model, year);
        this.maxPassengers = maxPassengers;
    }

    @Override
    public void transportPassengers(int passengers) {
        if (passengers <= maxPassengers) {
            System.out.println("Перевозка " + passengers + " пассажиров.");
        } else {
            System.out.println("Слишком много пассажиров. Максимум: " + maxPassengers);
        }
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
}
