package lesson18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MainNIO {
    public static void main(String[] args) throws IOException {
        Path pathDefault = Paths.get("testFileDef.txt");
        Path pathAbsolut = Path.of("d:/java/projects/students/Java210524/src/main/resources/testFileAbs.txt");
        Path pathRelative = Path.of("src/main/resources/testFileRel.txt");

        System.out.println("Абсолютный путь к файлу -> "+pathDefault.toAbsolutePath());
        System.out.println("getNameCount -> "+pathAbsolut.getNameCount());
        System.out.println("Root -> "+pathAbsolut.getRoot());
        System.out.println("getName -> "+pathRelative.getName(0));
        System.out.println("getName -> "+pathRelative.getName(pathRelative.getNameCount()-1));
        System.out.println("getParent() -> "+pathRelative.getParent());

        // == Files - работа с элементами файловой струткры
        System.out.println("Files.exists -> "+ Files.exists(pathDefault));
        if(Files.notExists(pathDefault)) {
            pathDefault = Files.createFile(pathDefault); //создание файла
        }
        // is....
        Path pathDirectory = Path.of("d:/java/projects/students");
        System.out.println("File -> "+Files.isDirectory(pathAbsolut));
        System.out.println("Directory -> "+Files.isDirectory(pathDirectory));

        // Метаданные - свойства элемента
        System.out.println("Метаданные - свойства элемента");
        System.out.println(Files.isHidden(pathDefault));
        System.out.println(Files.isExecutable(pathDefault));
        System.out.println(Files.isWritable(pathDefault));
        System.out.println(Files.isReadable(pathDefault));
        System.out.println(Files.getOwner(pathDefault));

        System.out.println("Один и тот же файл? ->" +Files.isSameFile(Path.of("d:/java/projects/students/Java210524/testFileDef.txt"),
            pathDefault));

      // Копирование
            //        StandardCopyOption.REPLACE_EXISTING заменять существующие файлы.
            //        StandardCopyOption.COPY_ATTRIBUTES копирует атрибуты файла.
            pathDefault = Files.copy(Paths.get("testRAF.txt"), pathDefault, StandardCopyOption.REPLACE_EXISTING,
                StandardCopyOption.COPY_ATTRIBUTES);

        // Перенос
        //        StandardCopyOption.REPLACE_EXISTING заменяет существующий файл, если он существует.
        //        StandardCopyOption.ATOMIC_MOVE попытка осуществить перемещение файла как единую атомарную операцию.
        //        Все остальные опции игнорируются.
        Path pathNew = Files.move(pathDefault, Path.of(pathAbsolut.getParent()+"/newFile.txt"),
            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.ATOMIC_MOVE);
        //Удаление
        System.out.println("Удаление - "+Files.deleteIfExists(Path.of(pathAbsolut.getParent()+"/newFile.txt")));
        //Удаление директория
        Path pathDir = Path.of(pathAbsolut.getParent()+"/testDir");
        if(Files.notExists(pathDir))
            pathDir = Files.createDirectory(pathDir);
        Files.copy(Paths.get("testRAF.txt"), Path.of(pathDir.toAbsolutePath()+"/testRAF.txt"),
            StandardCopyOption.REPLACE_EXISTING, StandardCopyOption.COPY_ATTRIBUTES);

        //Files.delete(pathDir); // не пустая папка -> DirectoryNotEmptyException
        // Удаляется только пустая папка
        System.out.println("deleteIfExists File -> "+Files.deleteIfExists(Path.of(pathDir.toAbsolutePath()+"/testRAF.txt")));
        System.out.println("deleteIfExists Directory -> "+Files.deleteIfExists(pathDir)); //Удаляется только пустая папка
    }
    }