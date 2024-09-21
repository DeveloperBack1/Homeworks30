package homework_2009.task2;


import java.util.*;

class Cat {
    String name;
    int age;
    double weight;
    String breed;

    public Cat(String name, int age, double weight, String breed) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return "Cat{name='" + name + "', age=" + age + ", weight=" + weight + ", breed='" + breed + "'}";
    }
}
