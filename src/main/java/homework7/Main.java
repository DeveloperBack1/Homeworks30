package homework7;


import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

            // Создаем компоненты дома
            Roof roof = new Roof("черепица");
            Walls walls = new Walls("кирпич");
            List<Window> windows = new ArrayList<>();
            windows.add(new Window(2));
            windows.add(new Window(3));
            windows.add(new Window(4));
            windows.add(new Window(5));
            Door door = new Door("ДЕРЕВО");


            House house = new House(roof, walls, windows, door,new ArrayList<>());

            // Добавляем жителей
            house.addResident(new Resident("Игорь"));
            house.addResident(new Resident("Анна"));
            house.addResident(new Resident("Алекс"));
            house.addResident(new Resident("Таня"));
            house.addResident(new Resident("Ира"));
            house.addResident(new Resident("Вадим"));
            house.addResident(new Resident("Роман"));

            // инфо о жителях

            for (Resident resident : house.getResidents()) {
                System.out.println("Житель дома: " + resident.getName());
            }

            System.out.println("\n");

            // инфо о добавленных окнах в доме
            for (Window window : house.getWindows()) {
                System.out.println("Добавленные окна в доме: "+ window.getArtGlassesGlasses()+"\n");
            }


            // инфо о дверях в доме

             System.out.println("Материал, из которого сделаны двери в доме: "
             + house.getDoor().getMaterial());


    }
        }
