package multithreading.synchronizer;

import java.util.List;
import java.util.concurrent.Exchanger;

class BestFriend extends Thread {

    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction, Action friendsAction) {
        if ((myAction == myAction.STEIN && friendsAction == friendsAction.SCHERE) ||
            (myAction == myAction.PAPIER && friendsAction == friendsAction.STEIN) ||
            (myAction == myAction.SCHERE && friendsAction == friendsAction.PAPIER)) {
            System.out.println(name + " wins!!!");
        }
    }

    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
