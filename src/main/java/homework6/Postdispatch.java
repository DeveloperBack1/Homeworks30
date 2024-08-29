package homework6;

public abstract class Postdispatch {


        protected String name;
        protected String sendAdress;
        protected String resAdress;

        // Конструктор


    public Postdispatch(String name, String sendAdress, String resAdress) {
        this.name = name;
        this.sendAdress = sendAdress;
        this.resAdress = resAdress;
    }

    // Абстрактные методы
        public abstract void delivered();// доставить адрессату
        public abstract void send(); //отправить
    }





        // Класс Бандероль
    class ParcelPost extends Postdispatch {

            public ParcelPost(String name, String sendAdress, String resAdress) {
                super(name, sendAdress, resAdress);
            }

            @Override
            public void delivered() {
                System.out.println("Бандероль \"" + name
                    + "\" доставлена по адресу: " + resAdress);
            }

            @Override
            public void send() {
                System.out.println("Бандероль \"" + name + "\" отправлена от: "
                    + sendAdress + " к: " + resAdress);
            }



    }

class Letter extends Postdispatch {

    public Letter(String name, String sendAdress, String resAdress) {
        super(name, sendAdress, resAdress);
    }

    @Override
    public void delivered() {
        System.out.println("Письмо \"" + name + "\" доставлено по адресу: " + resAdress);
    }

    @Override
    public void send() {
        System.out.println("Письмо \"" + name + "\" отправлено от: " + sendAdress + " к: " + resAdress);
    }
}

    // Класс Посылка
    class Parcel extends Postdispatch {
        private double weight;  // Дополнительное свойство

        public Parcel(String name, String sendAdress, String resAdress, double weight) {
            super(name, sendAdress, resAdress);
            this.weight = weight;
        }




        @Override
        public void delivered() {
            System.out.println("Посылка \"" + name + "\" весом " + weight
                + " кг доставлена по адресу: " + resAdress);
        }

        @Override
        public void send() {
            System.out.println("Посылка \"" + name + "\" весом " +
                weight + " кг отправлена от: " + sendAdress + " к: " + resAdress);
        }
    }


    class Container extends Postdispatch {
        private int count;  // Количество предметов в контейнере

        public Container(String name, String sendAdress, String resAdress, int count) {
            super(name, sendAdress, resAdress);
            this.count = count;
        }



        @Override
        public void delivered() {
            System.out.println("Контейнер \"" + name + "\" с " + count
                + " предметами доставлен по адресу: " + resAdress);
        }

        @Override
        public void send() {
            System.out.println("Контейнер \"" + name + "\" с " + count
                + " предметами отправлен от: " + sendAdress + " к: " + resAdress);
        }
    }

    // Пример использования




