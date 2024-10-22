package lesson4;

public class AccountTwoParamGeneric<T,S> {
  private T id;
  private S sum;

  public AccountTwoParamGeneric(T id, S sum) {
      this.id = id;
      this.sum = sum;
  }
  public T getId() {
      return id;
  }
  public S getSum() {
      return sum;
  }

    public void setSum(S sum) {
        this.sum = sum;
    }
}
