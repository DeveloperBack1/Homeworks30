package homework2510;
//Вы пишете книгу и вы автор. Есть 2 человека, которые выступают у вас соавторами.
//        На этапе написания книги, они пишут разные главы, помогая таким образом вам полностью ее закончить.
//        После того как вы и все соавторы закончили свою работу, вы отправляете книгу на рецензирование.
//        В группу рецензентов входит 3 человека, каждый из которых является специалистом в своей области
//        и проверяет Вашу книгу на правильность отражения фактов в вашем произведении.
//        После того. как все рецензии получены, Вы отправляете книгу в издательский дом.
//        В редакции главный редактор и руководитель издательства читают ваше творение и утверждают
//        его в печать.
//        Вы относите утвержденные рукописи печатникам, они печатают книгу, переплетчики делают ей переплет
//        а служба доставки развозят книги по магазинам.
//        Поздравляю Вас, вы полностью прошли все фазы становления известного писателя, т.к. Ваша книга
//        стала бестселлером! )
//        Создайте приложение, которое сымитирует работу процесса создания книги, с учетом, что каждый человек,
//        который встречается в описанной схеме будет представлен отдельным потоком.
//        Какой синхронизатор с библиотеки concurrent мог бы быть Вам полезен при выполнении данной задачи?

import java.util.concurrent.Phaser;

public class BookCreationWithPhaser {

    public static void main(String[] args) {

        // Создаем Phaser с количеством участвующих на первом этапе - 3 (Автор и 2 соавтора)
        Phaser phaser = new Phaser(1);
        // 1 - основной поток

     int currentPhase;

        // Этап 1: Написание книги
        System.out.println("Этап 1: Начинается написание книги");
        new Thread(new Writer(phaser, "Автор")).start();
        new Thread(new Writer(phaser, "Соавтор 1")).start();
        new Thread(new Writer(phaser, "Соавтор 2")).start();

        currentPhase = phaser.getPhase();

        // Ожидаем завершения этапа написания
        phaser.arriveAndAwaitAdvance();
        System.out.println("Этап 1 завершен. Все главы написаны.");

        // Этап 2: Рецензирование
        System.out.println("Этап 2: Начинается рецензирование");
      // Регистрируем 3 рецензентов
        new Thread(new Reviewer(phaser, "Рецензент 1")).start();
        new Thread(new Reviewer(phaser, "Рецензент 2")).start();
        new Thread(new Reviewer(phaser, "Рецензент 3")).start();

        // Ожидаем завершения этапа рецензирования
        phaser.arriveAndAwaitAdvance();
        System.out.println("Этап 2 завершен. Все рецензии получены.");

        // Этап 3: Утверждение издательством
        System.out.println("Этап 3: Утверждение книги издательством");
      // Регистрируем редактора и руководителя издательства
        new Thread(new Approver(phaser, "Главный редактор")).start();
        new Thread(new Approver(phaser, "Руководитель издательства")).start();

        // Ожидаем завершения утверждения
        phaser.arriveAndAwaitAdvance();
        System.out.println("Этап 3 завершен. Книга утверждена для печати.");

        // Этап 4: Печать и распространение
        System.out.println("Этап 4: Печать и распространение книги");

        new Thread(new PrintingTask(phaser, "Печатник")).start();
        new Thread(new PrintingTask(phaser, "Переплетчик")).start();
        new Thread(new PrintingTask(phaser, "Служба доставки")).start();

        // Ожидаем завершения печати и распространения
        phaser.arriveAndAwaitAdvance();
        System.out.println("Процесс завершен! Книга доступна в магазинах. Поздравляем!");

        phaser.arriveAndDeregister(); // Отключаем основной поток
    }

    // Класс для написания
    static class Writer implements Runnable {
        private Phaser phaser;
        private String name;

        public Writer(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register(); // Регистрация потока в Phaser
        }

        @Override
        public void run() {
            System.out.println(name + " пишет свою часть книги.");
//
            try {
                Thread.sleep(2000); // Симулируем время написания
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//
            System.out.println(name + " закончил писать.");
            phaser.arriveAndDeregister();
        }
    }

    // Класс для рецензентов
    static class Reviewer implements Runnable {
        private Phaser phaser;
        private String name;

        public Reviewer(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register();


        }

        @Override
        public void run() {
            System.out.println(name + " проверяет книгу.");
//            try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//
            System.out.println(name + " завершил рецензирование.");
            phaser.arriveAndDeregister();
        }
    }

    // Класс для утверждения
    static class Approver implements Runnable {
        private Phaser phaser;
        private String name;

        public Approver(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register();
        }

        @Override
        public void run() {
            System.out.println(name + " утверждает книгу.");
//
            try {
                Thread.sleep(2000); // Симулируем время утверждения
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//
            System.out.println(name + " завершил утверждение.");
            phaser.arriveAndDeregister();
        }
    }

    // Класс для печатника, переплетчика и службы доставки
    static class PrintingTask implements Runnable {
        private Phaser phaser;
        private String name;

        public PrintingTask(Phaser phaser, String name) {
            this.phaser = phaser;
            this.name = name;
            phaser.register();
        }

        @Override
        public void run() {
            System.out.println(name + " выполняет свою работу.");
//
            try {
                Thread.sleep(2000); // Симулируем выполнение работы
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
//
            System.out.println(name + " завершил свою работу.");
            phaser.arriveAndDeregister();
        }
    }
}
