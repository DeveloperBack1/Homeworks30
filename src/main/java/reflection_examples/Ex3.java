package reflection_examples;

import java.lang.reflect.Field;

public class Ex3 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Employee employee = new Employee(10,"Max","IT");
        Class employeeClass = employee.getClass();
        Field field = employeeClass.getDeclaredField("salary");

        field.setAccessible(true); // получаем доступ к полю, даже если оно private!!!

        double salaryValue = (Double) field.get(employee);
        System.out.println(salaryValue);

        field.set(employee,10000.00);
        System.out.println(employee);

    }
}
