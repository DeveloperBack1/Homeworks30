package aggregation_composition;

public class App {
    public static void main(String[] args) {
       // Composition
        Heart heart = new Heart();
        Human human = new Human(heart);
        human.getHeart().heartPounding();

    }
}
