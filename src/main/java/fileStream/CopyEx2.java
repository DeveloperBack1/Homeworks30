package fileStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyEx2 {
    public static void main(String[] args) {
        try(FileInputStream inputStream = new FileInputStream("text2.txt");
            FileOutputStream outputStream = new FileOutputStream("text4.txt");) {
            int i;
            while ((i=inputStream.read())!=-1){
                outputStream.write(i);
            }
            System.out.println("Done!");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
