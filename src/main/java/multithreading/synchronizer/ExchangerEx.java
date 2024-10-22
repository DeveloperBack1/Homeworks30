package multithreading.synchronizer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    public static void main(String[] args) {

Exchanger<Action> exchanger = new Exchanger<>();

List<Action> friend1Action = new ArrayList<>();
friend1Action.add(Action.PAPIER);
friend1Action.add(Action.PAPIER);
friend1Action.add(Action.SCHERE);

List<Action> friend2Action = new ArrayList<>();
friend2Action.add(Action.STEIN);
friend2Action.add(Action.STEIN);
friend2Action.add(Action.STEIN);

new BestFriend("Igor", friend1Action, exchanger);
new BestFriend("Sergej", friend2Action, exchanger);
    }
}

