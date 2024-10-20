package homework1810;


import java.util.concurrent.atomic.AtomicInteger;

public class Course {
    
    private static final int STUDENT_FEE = 1000;  // Стоимость курса для одного студента
    private static final int TARGET_PROFIT = 1_000_000;  // Целевая прибыль компании
    private static final double TEACHER_PERCENTAGE = 0.10;  // Процент преподавателя

    // Переменные для отслеживания прибыли
    private AtomicInteger totalIncome = new AtomicInteger(0);  // Общая прибыль компании

    // Метод для добавления студента и расчета прибыли
    public void enrollStudent() {
        // Добавляем стоимость курса
        int studentIncome = STUDENT_FEE - (int) (STUDENT_FEE * TEACHER_PERCENTAGE);
        totalIncome.addAndGet(studentIncome);
    }

    // Метод для проверки, достигла ли компания цели
    public boolean hasReachedTarget() {
        return totalIncome.get() >= TARGET_PROFIT;
    }

    // Метод для получения текущей прибыли
    public int getCurrentProfit() {
        return totalIncome.get();
    }

    public static void main(String[] args) {
        Course course = new Course();  // Создаем курс

        int studentCount = 0;  // Счетчик студентов

        // Набираем студентов, пока прибыль не достигнет 1 миллиона
        while (!course.hasReachedTarget()) {
            course.enrollStudent();
            studentCount++;
            System.out.println("Набрали студента " + studentCount + ". Текущая прибыль компании: " + course.getCurrentProfit());
        }

        System.out.println("Цель достигнута! Набрано студентов: " + studentCount);
        System.out.println("Финальная прибыль компании: " + course.getCurrentProfit());
    }
}
