package lesson4;

public class AccountInterface1 implements Sumable<Integer> {

    private int id;
    private Integer sum;

    public AccountInterface1(int id, Integer sum) {
        this.id = id;
        this.sum = sum;
    }
    @Override
    public Integer getSum() {
        return sum;
    }

    public int getId() {
        return id;
    }

    @Override
    public void setSum(Integer sum) {
    this.sum = sum;
    }
}
