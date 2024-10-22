package fileStream;

import java.io.FileWriter;
import java.io.IOException;



public class FileWriterEx {
    public static void main(String[] args) throws IOException {

        String s = "My name is Max!\n" +
            "I am Programmer!\n";
        String s1 = "My first daughter is Debora!\n";
        String s2 = "My second daughter is Valeria Schneider!\n";
        String s3 = "My third daughter is Sofia Schneider!\n";




        try(FileWriter writer= new FileWriter("text2.txt", true))
        {

            writer.write(s);
            writer.write(s1);
            writer.write(s2);
            writer.write(s3);

//            for (int i = 0; i < s.length(); i++) {
//                writer.write(s.charAt(i));
//            }
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}








