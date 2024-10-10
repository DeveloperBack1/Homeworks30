package homework1010;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Client
        Client client = new Client(1L, "Active", 123456789L, "John", "Doe", "john.doe@example.com", "123 Main St", "1234567890");

        // Сохраняем объект Client в файл
        String fileName = "client.txt";
        ClientSaver.saveClientToFile(client, fileName);

        // Читаем объект Client из файла
        Client loadedClient = ClientReader.readClientFromFile(fileName);
        if (loadedClient != null) {
            System.out.println("Loaded Client: " + loadedClient);
        }
    }
}
