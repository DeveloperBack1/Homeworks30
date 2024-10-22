package lesson4;

public class AccountInterface3<T,S> implements Accountable<T,S>{

    private T id;
    private S sum;

    public AccountInterface3(T id, S sum) {
        this.id = id;
        this.sum = sum;
    }

    @Override
    public T getId() {
        return id;
    }

    @Override
    public S getSum() {
        return sum;
    }

    @Override
    public void setSum(S sum) {
       this.sum = sum;
    }
}
