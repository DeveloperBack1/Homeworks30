package homework1010;


public class Client {
    private Long id;
    private String status;
    private Long taxCode;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String phone;

    // Конструктор
    public Client(Long id, String status, Long taxCode, String firstName, String lastName, String email, String address, String phone) {
        this.id = id;
        this.status = status;
        this.taxCode = taxCode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTaxCode() {
        return taxCode;
    }

    public void setTaxCode(Long taxCode) {
        this.taxCode = taxCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Преобразование объекта в строку
    @Override
    public String toString() {
        return id + "," + status + "," + taxCode + "," + firstName + "," + lastName + "," + email + "," + address + "," + phone;
    }

    // Метод для создания объекта Client из строки
    public static Client fromString(String data) {
        String[] fields = data.split(",");
        Long id = Long.parseLong(fields[0]);
        String status = fields[1];
        Long taxCode = Long.parseLong(fields[2]);
        String firstName = fields[3];
        String lastName = fields[4];
        String email = fields[5];
        String address = fields[6];
        String phone = fields[7];
        return new Client(id, status, taxCode, firstName, lastName, email, address, phone);
    }
}
