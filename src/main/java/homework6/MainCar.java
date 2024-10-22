package homework6;


public class MainCar {
    public static void main(String[] args) {

        Car car = new Car("BMW", "Alpina", 2020, true);

        CarMechanic mechanic = new Mechanic(car);
        CarDriver chauffeur = new Chauffeur(car);

       CarMechanic auto = () -> System.out.println("Auto fährt schnell!!!");
       auto.engineFix();


        mechanic.engineFix();


        chauffeur.engineStart();
        chauffeur.drive();


        chauffeur.stop();
    }
}
