package homework1010;


import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
//import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ClientReader {

    public static Client readClientFromFile(String fileName) {
        try (FileChannel fileChannel = FileChannel.open(Paths.get(fileName), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate((int) fileChannel.size()); // Создаем буфер размером с файл
            fileChannel.read(buffer); // Читаем данные из файла
            buffer.flip(); // Подготавливаем буфер к чтению
            String data = new String(buffer.array()); // Преобразуем байты обратно в строку
            String[] lines = data.split(System.lineSeparator()); // Разделяем строки
            if (lines.length > 0) {
                return Client.fromString(lines[0]); // Преобразуем первую строку в объект Client
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
