package homework7;


public class MainCar {
    public static void main(String[] args) {

        Car car = new Car("BMW", "Alpina", 2020, true);

        CarMechanic mechanic = new Mechanic(car);
        CarDriver chauffeur = new Chauffeur(car);

        mechanic.engineFix();


        chauffeur.engineStart();
        chauffeur.drive();


        chauffeur.stop();
    }
}
