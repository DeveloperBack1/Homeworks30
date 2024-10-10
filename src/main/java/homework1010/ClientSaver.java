package homework1010;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.StandardOpenOption;
import java.nio.file.Paths;

public class ClientSaver {

    public static void saveClientToFile(Client client, String fileName) {
        try (FileChannel fileChannel = FileChannel.open(Paths.get(fileName), StandardOpenOption.CREATE, StandardOpenOption.WRITE)) {
            String clientData = client.toString() + System.lineSeparator(); // Добавляем новую строку
            ByteBuffer buffer = ByteBuffer.wrap(clientData.getBytes()); // Преобразуем строку в массив байтов
            fileChannel.write(buffer); // Записываем данные в файл
            System.out.println("Client saved to file: " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
