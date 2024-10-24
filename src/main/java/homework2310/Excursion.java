package homework2310;

//Вы едете на экскурсии. Каждый человек, при входе в автобус, называет свою фамилию.
//        Экскурсовод ставит у себя в блокноте птичку и если количество людей по списку совпадает
//        автобус уезжает на экскурсию. Сымитируйте данный процесс работы.
//        Какой синхронизатор с библиотеки concurrent Вы бы использовали для данного процесса?

import java.util.concurrent.CyclicBarrier;


public class Excursion {

    // Определяем количество мест в автобусе
    private static final int TOTAL_PEOPLE = 5;

    public static void main(String[] args) {

        // Создаем барьер, который ожидает 5 человек и после этого выполняет команду отправления автобуса
        CyclicBarrier barrier = new CyclicBarrier(TOTAL_PEOPLE, new Runnable() {
            @Override
            public void run() {
                System.out.println("Все пассажиры в автобусе! Поехали на экскурсию!");
            }
        });

        // Создаем потоки (людей), которые будут заходить в автобус
        for (int i = 1; i <= TOTAL_PEOPLE; i++) {
            new Thread(new Person(barrier, "Пассажир " + i)).start();
        }
    }
}

// Класс описывающий человека
class Person implements Runnable {
    private CyclicBarrier barrier;
    private String name;

    public Person(CyclicBarrier barrier, String name) {
        this.barrier = barrier;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " заходит в автобус.");
            // Человек ждет других пассажиров на барьере
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
