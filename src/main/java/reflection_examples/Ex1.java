package reflection_examples;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Ex1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // Варианты создания объекта класса типаClass:

        Class employeeClass = Class.forName("reflection_examples.Employee");
//        Class employeeClass1 = Employee.class;
//        Employee emp = new Employee();
//        Class employeeClass2 = emp.getClass();

        // Доступ к полям :

        Field someField = employeeClass.getField("id");
        System.out.println("Type of id field: " + someField.getType());
        System.out.println("*****");

        Field[] fields = employeeClass.getFields();
        for (Field field : fields) {
            System.out.println("Type of field: " + field.getName() + " = " + field.getType());
        }
        System.out.println("*****");

        Field[] allFields = employeeClass.getDeclaredFields();
        for (Field field : allFields) {
            System.out.println("Type of field: " + field.getName() + " = " + field.getType());
        }

        System.out.println("_____________________________________________________________");

        //   Доступ к методам:

        Method someMethod1 = employeeClass.getMethod("increaseSalary");
        System.out.println("Return type of method increaseSalary: "
            + someMethod1.getReturnType() + ", parameter types: "
            + Arrays.toString(someMethod1.getParameterTypes()));

        Method someMethod2 = employeeClass.getMethod("setSalary", double.class);
        System.out.println("Return type of method setSalary: "
            + someMethod2.getReturnType() + ", parameter types: "
            + Arrays.toString(someMethod2.getParameterTypes()));
        System.out.println("*****");

        Method[] methods = employeeClass.getMethods();
        for (Method method : methods) {
            System.out.println(" Name of method: " + method.getName() + "return type: "
                + method.getReturnType() + ", parameter types: "
                + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("*****");

        Method[] allMethods = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            System.out.println(" Name of method: " + method.getName() + " return type: "
                + method.getReturnType() + ", parameter types: "
                + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("*****");

        Method[] allMethods2 = employeeClass.getDeclaredMethods();
        for (Method method : allMethods) {
            if (Modifier.isPublic(method.getModifiers()))
                System.out.println(" Name of method: " + method.getName() + " return type: "
                    + method.getReturnType() + ", parameter types: "
                    + Arrays.toString(method.getParameterTypes()));
        }
        System.out.println("_______________________________________________");

        // Доступ к конструкторам:

        Constructor constructor1 = employeeClass.getConstructor();
        System.out.println("Constructor has: " + constructor1.getParameterCount()
            + " parameters, their types are: "
            + Arrays.toString(constructor1.getParameterTypes()));
        System.out.println("*****");

        Constructor constructor2 = employeeClass.getConstructor(int.class, String.class, String.class);
        System.out.println("Constructor has: " + constructor2.getParameterCount()
            + " parameters, their types are: "
            + Arrays.toString(constructor2.getParameterTypes()));
        System.out.println("*****");

      Constructor [] constructors = employeeClass.getConstructors();
      for (Constructor constructor : constructors) {
          System.out.println("Constructor has: " + constructor.getParameterCount()
              + " parameters, their types are: "
              + Arrays.toString(constructor.getParameterTypes()));
      }
    }
}
