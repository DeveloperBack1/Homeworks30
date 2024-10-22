package practice0409;

public enum DishType {
    PIZZA(20),BURGER(10),SUSHI(5),PASTA(20);
    private int cookingTime;

    DishType(int cookingTime) {
        this.cookingTime = cookingTime;
    }
    public int getCookingTime() {
        return cookingTime;
    }

}
