package homework6;


public class Main {
    public static void main(String[] args) {
        Postdispatch letter = new Letter("Письмо другу", "г. Львов, ул. Шевченко, д. 1", "г. Киев, ул. Пушкина, д. 5");
        ParcelPost parcelPost = new ParcelPost("Документы", "г. Умань, ул. Баумана, д. 10", "г. Днепр, ул. Гоголя, д. 7");
        Parcel parcel = new Parcel("Игрушки", "г. Павлоград, ул. Сибири, д. 3", "г. Чернигов, ул. Суворова, д. 9", 2.5);
        Container container = new Container("Оборудование", "г. Екатеринбург, ул. Гагарина, д. 15", "г. Новосибирск, ул. Дзержинского, д. 11", 100);

        letter.send();
        letter.delivered();

        parcelPost.send();
        parcelPost.delivered();

        parcel.send();
        parcel.delivered();

        container.send();
        container.delivered();
    }
}
