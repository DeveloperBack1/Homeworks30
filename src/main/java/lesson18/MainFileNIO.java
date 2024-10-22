package lesson18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainFileNIO {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("testRAF.txt");
       List<String> lists = Files.readAllLines(path);
        System.out.println(lists);

        System.out.println("_____________________");

        byte[] bytes = Files.readAllBytes(path);
        System.out.println(new String(bytes));

//        System.out.println("______________________");
//        System.out.println(Files.write(Path.of("newBytes.txt"), bytes));

        Path pathNew =Files.write( Path.of("newBytes.txt"), bytes);
        System.out.println(pathNew);
    }
}
