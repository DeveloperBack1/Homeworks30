package fileStream;

import java.io.*;

public class CopyEx {
    public static void main(String[] args) throws FileNotFoundException {
        try(BufferedReader br=new BufferedReader(new FileReader("text2.txt"));
            BufferedWriter bw=new BufferedWriter(new FileWriter("text3.txt"))) {
////int character;
////while((character=br.read())!=-1){
////    bw.write(character);
//}
 String line;
      while((line=br.readLine())!=null){
          bw.write(line);
          bw.write("\n");
      }
            System.out.println("Done!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
