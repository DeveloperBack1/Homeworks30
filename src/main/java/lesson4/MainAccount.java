package lesson4;

public class MainAccount {
    public static void main(String[] args) {
       Account account1 = new Account(1234,111 );
        System.out.println("Account: "+account1.getId()+ " -> "+ account1.getSum());

        AccountObject accountObject1 = new AccountObject(1234, 100);
        // Object id = new Integer(1234)
        System.out.println("AccountObject: "+accountObject1.getId()+ " -> "+
            accountObject1.getSum());

        AccountObject accountObject2 = new AccountObject("DE1234", 111);
        System.out.println(accountObject2.getId()+ " -> "+ accountObject2.getSum());

        AccountObject accountObject3 = new AccountObject(true, 111);
        System.out.println(accountObject3.getId()+ " -> "+ accountObject2.getSum());

        AccountGeneric<Integer> accountGeneric1 = new AccountGeneric<Integer>(1234, 120);
        System.out.println("AccountGeneric: "+accountGeneric1.getId()+ " -> "+
            accountGeneric1.getSum());

        AccountTwoParamGeneric<Integer,Double> accountTwoParamGeneric1=
            new AccountTwoParamGeneric<>(123,235.89);
        System.out.println("AccountTwoParamGeneric: "+accountTwoParamGeneric1.getId()+ " -> "
            + accountTwoParamGeneric1.getSum());

        AccountInterface1 accountInterface1 =new AccountInterface1(1234, 111);
        System.out.println(accountInterface1.getId()+ " -> "+ accountInterface1.getSum());

        AccountInterface2<Double> accountInterface2 = new AccountInterface2<>(123,235.89);
     System.out.println("AccountInterface2: "+accountInterface2.getId()+
         " -> "+accountInterface2.getSum());

     AccountInterface3<Integer,Double> accountInterface3 = new AccountInterface3<>(123,235.89);
     System.out.println("AccountInterface3: "+accountInterface3.getId()+ " -> "+ accountInterface3.getSum());
    }
}
