package homework6;
//1) Напишите утилитный класс, в котором реализованы методы получения среднего значения AVG,
//максимального MAX и минимального значения MIN из следующих наборов данных:
//    - пары целых чисел
//  - пары дробных чисел
//  - одного целого и одного дробного числа
//  - массива целых чисел
//  - массива дробных чисел
//Используйте механизм перегрузки.
//
//2) Есть абстрактный класс ПочтовоеОтправление, в котором представлен набор характеристик:
//    - наименование;
//   - адрес отправителя;
//   - адрес получателя;
//и абстрактное поведение:
//    - доставить адресату;
//   - отправить;
//Реализуйте методы этого абстрактного класса в его потомках
//Письмо, Бандероль, Посылка, Контейнер с учетом той специфики, которая характерна для каждого
//типа почтовых отправлений на Ваше усмотрение и определить их поведение.
//
//    3*) Есть класс Авто со свои набором характеристик и поведения.
//    Подумайте, какие ресурсы класса Авто могут доступны только Автомеханику, а какие простому Водителю.
//Создайте интерфейсы Автомеханик и Водитель, и с их помощью разделите доступ к методам класса Авто.

public class UtilityClass{


        //  Среднее значение

        public static double avg(int a, int b) {
            return (a + b) / 2.0;
        }

        public static double avg(double a, double b) {

            return (a + b) / 2.0;
        }

        public static double avg(int a, double b) {
            return (a + b) / 2.0;
        }

        public static double avg(int[] arr) {
            int sum = 0;
            for (int value : arr) {
                sum += value;
            }
            return (double) sum / arr.length;
        }

        public static double avg(double[] arr) {
            double sum = 0;
            for (double value : arr) {
                sum += value;
            }
            return sum / arr.length;
        }

        // MAX:

        public static int max(int a, int b) {
            return Math.max(a, b);
        }

        public static double max(double a, double b) {
            return Math.max(a, b);
        }

        public static double max(int a, double b) {
            return Math.max(a, b);
        }

        public static int max(int[] arr) {
            int max = arr[0];
            for (int value : arr) {
                if (value > max) {
                    max = value;
                }
            }
            return max;
        }

        public static double max(double[] arr) {
            double max = arr[0];
            for (double value : arr) {
                if (value > max) {
                    max = value;
                }
            }
            return max;
        }

        // MIN:

        public static int min(int a, int b) {
            return Math.min(a, b);
        }

        public static double min(double a, double b) {
            return Math.min(a, b);
        }

        public static double min(int a, double b) {
            return Math.min(a, b);
        }

        public static int min(int[] arr) {
            int min = arr[0];
            for (int value : arr) {
                if (value < min) {
                    min = value;
                }
            }
            return min;
        }

        public static double min(double[] arr) {
            double min = arr[0];
            for (double value : arr) {
                if (value < min) {
                    min = value;
                }
            }
            return min;
        }
    }



