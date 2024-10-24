package reflection_examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Calculator {
    void summ(int a, int b) {
        int result = a + b;
        System.out.println(result);
    }

    void division(int a, int b) {
        int result = a/b;
        System.out.println(result);
    }

    void subtraction(int a, int b) {
        int result = a - b;
        System.out.println(result);
    }

    void multiplication(int a, int b) {
        int result = a * b;
        System.out.println(result);
    }

}

class TestCalculator {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test100.txt"))) {
              String methodName = bufferedReader.readLine();
              String firstArgument = bufferedReader.readLine();
              String secondArgument = bufferedReader.readLine();

            Calculator calculator = new Calculator();
            Class cl = calculator.getClass();
            Method method = null;
            Method[] methods = cl.getDeclaredMethods();
            for (Method myMethod : methods) {
                if (myMethod.getName().equals(methodName)) {
                    method = myMethod;
                }
            }
            method.invoke(calculator,Integer.parseInt(firstArgument),Integer.parseInt(secondArgument));

        } catch (FileNotFoundException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
