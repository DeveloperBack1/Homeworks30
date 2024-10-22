package fileStream;

import java.io.*;

public class MainFile10 {
    public static void main(String[] args) {
        String nameFile = "testFile.txt";
        File testFile = new File(nameFile);
        // запись в файл
        OutputStream streamOut = null;
        try {
            if (!testFile.exists()) {
                if (testFile.createNewFile()) { //создаем файл
                    streamOut = new FileOutputStream(testFile);
                    String str = "This string I can output to file";
                    byte[] output = str.getBytes();
                    streamOut.write(output);
                }
            }
        } catch (IOException ex) {
            System.err.println("Возникла ошибка записи информации в файл -> "+nameFile);
        } finally { // опять это же исключение
            try {
                if(streamOut!=null) streamOut.close(); //после использования нужно обязательно закрыть
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        // читаем из файла
        try (InputStream streamIn = new FileInputStream(testFile);
             Reader reader = new InputStreamReader(streamIn)) { // try c ресурсами
            StringBuilder inStr = new StringBuilder(); // накапливать в строку
            int data = reader.read();
            while (data != -1) {
                inStr.append((char)data);
                System.out.print((char)data);
                data = reader.read();
            }
            System.out.println();
            System.out.println("Input from file -> "+inStr);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
