package aggregation_composition;

import java.util.ArrayList;
import java.util.List;

public class App2 {
    public static void main(String[] args) {
      Person drivers1 = new Person("John", 23);
      Person drivers2 = new Person("Andre", 25);
      Person drivers3 = new Person("Silvia", 27);
      Person drivers4 = new Person("Michael", 21);

        List <Person> drivers = new ArrayList<>();
        drivers.add(drivers1);
        drivers.add(drivers2);
        drivers.add(drivers3);
        drivers.add(drivers4);

        Company company = new Company();
        company.setDrivers(drivers);

        for (Person driver : company.getDrivers()) {
            System.out.println(driver.getName()+ " "+ driver.getId());
        }



    }
}
