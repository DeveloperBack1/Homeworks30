package homework6;

public class Car {

    private String marke;
    private String model;
    private int issueYear;
    private boolean engineRun;


    public Car(String marke, String model, int issueYear, boolean engineRun) {
        this.marke = marke;
        this.model = model;
        this.issueYear = issueYear;
        this.engineRun = false;
    }

    // Метод   механика
    public void engineFix() {
        if (!engineRun) {
            engineRun = true;
            System.out.println("Двигатель починен.");
        } else {

            System.out.println("Двигатель уже работает.");
        }
    }

    // Метод  водителя
    public void engineStart() {
        if (!engineRun) {
            System.out.println("Двигатель не работает, необходимо его починить.");
        } else {
            System.out.println("Двигатель заведен.");
        }
    }

    // Метод водителя
    public void drive() {
        if (engineRun) {
            System.out.println("Машина едет.");
        } else {
            System.out.println("Невозможно ехать. Двигатель не работает.");
        }
    }

    // Метод водителя
    public void stop() {
        System.out.println("Машина остановилась.");
    }
}

