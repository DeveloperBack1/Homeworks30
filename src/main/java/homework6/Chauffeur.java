package homework6;

public class Chauffeur implements CarDriver{

    Car car;

    public Chauffeur(Car car) {
        this.car = car;
    }
    @Override
    public void engineStart() {
        car.engineStart();
    }

    @Override
    public void drive() {
    car.drive();
    }

    @Override
    public void stop() {
       car.stop();
    }
}
