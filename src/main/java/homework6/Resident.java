package homework6;


import java.util.List;
import java.util.ArrayList;

//Есть класс Дом и в нем живет много объектов типа Житель.
//У Дома так же есть объекты Крыша, Стены, Окна, Двери.
//Создайте класс для сущности Дом и ассоциированные с ни объекты, входящий в него.
//Подумайте какие из них агрегируются с домом, а какие связаны отношением Композиция.

// Класс Житель
class Resident {
    private String name;


    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Класс Крыша
class Roof {
    private String material;

    public Roof(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}

// Класс Стены
class Walls {
    private String material;

    public Walls(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}

// Класс Окно
class Window {
    private int artGlasses;

    public Window(int artGlasses) {
        this.artGlasses = artGlasses;
    }

    public int getArtGlassesGlasses() {
        return artGlasses;
    }
}
// Класс Дверь
class Door {

    private String material;

    public Door(String material) {
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }
}

// Класс Дом
class House {
    private Roof roof;
    private Walls walls;
    private List<Window> windows;
    private Door door;
    private List<Resident> residents;

    public House(Roof roof, Walls walls, List<Window> windows, Door door, List<Resident> residents) {
        this.roof = roof;
        this.walls = walls;
        this.windows = windows;
        this.door = door;
        this.residents = new ArrayList<>();
    }

    // Метод для добавления жителя
    public void addResident(Resident resident) {
        residents.add(resident);
    }

    public List<Resident> getResidents() {
        return residents;
    }

    public Roof getRoof() {
        return roof;
    }

    public Walls getWalls() {
        return walls;
    }

    public List<Window> getWindows() {
        return windows;
    }

    public Door getDoor() {
        return door;
    }
}