package homework_alg_1510;


class MyLinkedList {

    // Внутренний класс для узла списка
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    // Метод добавления элемента в конец списка
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Метод создания петли: заставляет последний узел ссылаться на узел с индексом loopIndex
    public void createLoop(int loopIndex) {
        if (head == null) {
            return;
        }

        Node loopNode = null;
        Node current = head;
        int count = 0;

        while (current.next != null) {
            if (count == loopIndex) {
                loopNode = current;
            }
            current = current.next;
            count++;
        }

        // Если loopNode был найден, создаем петлю
        if (loopNode != null) {
            current.next = loopNode;
        }
    }

    // Метод для обнаружения петли (алгоритм Флойда)
    public boolean detectLoop() {
        if (head == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // медленный указатель движется на 1 шаг
            fast = fast.next.next;    // быстрый указатель движется на 2 шага

            // Если медленный и быстрый указатели встретились, есть петля
            if (slow == fast) {
                return true;
            }
        }

        return false; // Петли нет
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        // Создание петли: последний элемент ссылается на элемент с индексом 2 (т.е. на "3")
        list.createLoop(2);

        // Проверка на наличие петли
        if (list.detectLoop()) {
            System.out.println("Петля обнаружена");
        } else {
            System.out.println("Петля не обнаружена");
        }
    }
}
