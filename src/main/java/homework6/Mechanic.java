package homework6;


public class Mechanic implements CarMechanic {


    Car car;

    public Mechanic(Car car) {
        this.car = car;
    }

    @Override
    public void engineFix() {

        car.engineFix();


    }
}