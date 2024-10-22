package fileStream;

import java.io.*;
public class MainSystemIO {
    public static void main(String[] args) {
        // InputStream
        InputStream inputStream = System.in; // байтовый поток
        Reader reader = new InputStreamReader(inputStream); // преобразование в символьный поток
        BufferedReader bufferedReader = new BufferedReader(reader);
        String s = null;
        System.out.print("Введите число: ");
        int num;
        try {
            s = bufferedReader.readLine();
            num = Integer.parseInt(s);
        } catch (NumberFormatException | IOException e) {
            System.err.println("Ошибка ввода информации");
            throw new RuntimeException(e);
        }
        System.out.println("InputStream = "+num);  
        
    }
}
