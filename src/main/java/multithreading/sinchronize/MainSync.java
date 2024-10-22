package multithreading.sinchronize;

public class MainSync {
    public static void main(String[] args) throws InterruptedException {

    Account account = new Account();
    Thread father = new PlusThread(account, 10);
    Thread children = new MinusThread(account, 10);

    System.out.println("До - "+account.getSum());

    father.start(); // + 1 млн.
    children.start(); // - 1 млн.

    father.join();
    children.join();

    System.out.println("После - "+account.getSum());

}
}
