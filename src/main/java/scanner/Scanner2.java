package scanner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Scanner2 {
    public static void main(String[] args) {
        Scanner scanner = null;
        Set<String> set = new TreeSet<>();
        try{
            scanner = new Scanner(new FileReader("text2.txt"));
            scanner.useDelimiter("\\W");
            while(scanner.hasNext()){
                String word = scanner.next();
                set.add(word);

            }
            for(String word : set){
                System.out.println(word);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("File not found");
        }
        finally{
            scanner.close();
        }
    }
}
