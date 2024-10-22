package fileStream;

import java.io.File;
import java.nio.file.Files;

public class FileEx {
    public static void main(String[] args) {
        File file = new File("Text7.txt");
        File folder = new File("/Users/maxschneider/IdeaProjects/Homeworks5/text1.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(folder.getAbsolutePath());
        System.out.println("_____________________________________");

        System.out.println(file.isAbsolute());
        System.out.println(folder.isAbsolute());
        System.out.println("_________________________________________");

        System.out.println(file.isDirectory());
        System.out.println(folder.isDirectory());
        System.out.println("_________________________________________");
    }
}
