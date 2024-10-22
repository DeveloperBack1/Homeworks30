package fileStream;

import java.io.File;
import java.io.IOException;

public class MainFileSystemIO {
    public static void main(String[] args) throws IOException {
        File file = new File("./file.txt");

        boolean isExists = file.exists();
        System.out.println(isExists);

        boolean wasCreatedFile = file.createNewFile();
        System.out.println(wasCreatedFile);

        long length = file.length();
        System.out.println("size of file-> " + length);

        boolean success = file.delete();
        System.out.println("delete of file-> " + success);

        // ==== Работа с папками ====

        // создание
        File dir = new File("new_dir");
        if (!dir.exists()) {
            System.out.println("Created new dir -> " + dir.mkdir());
        }

        File inFile = new File(dir, "newFile.txt");
        if (!inFile.exists()) {
            System.out.println("created file " + inFile.createNewFile());
        }

        // Проверка
        System.out.println("Is Folder -> " + dir.isDirectory());

        // Удаление
        File[] files = dir.listFiles(); // возвращает вложенные папки и файлы
        for (File fileDel : files) {
            // Проверка
            System.out.println("Is File -> " + fileDel.isFile());
            //удаление вложенного файла
            success = fileDel.delete();
            System.out.println("delete " + fileDel.getName() + " -> " + success);
        }

        // удаление папки
        success = dir.delete(); // только пустые каталоги можно удалить
        System.out.println("delete dir - " + success);
    }
}
