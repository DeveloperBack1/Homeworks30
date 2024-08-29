package homework6;


public class MainCar {
    public static void main(String[] args) {
        Car car = new Car("BMW", "Alpina", 2020, true);

        CarMechanic mechanic = new Mechanic(car);
        CarDriver chauffeur = new Chauffeur(car);

        // Механик пытается починить двигатель
        mechanic.engineFix();

        // Шофер пытается завести двигатель и ехать
        chauffeur.engineStart();
        chauffeur.drive();

        // Шофер останавливается
        chauffeur.stop();
    }
}
