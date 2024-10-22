package multithreading.sinchronize.collections;

import java.util.HashMap;
import java.util.Iterator;

public class ConcurrentHashMapEx {
    public static void main(String[] args) {
        HashMap <Integer, String> map = new HashMap<>();
        map.put(1, "Max");
        map.put(2, "Maria");
        map.put(3, "Natascha");
        map.put(4, "Debora");
        map.put(5, "Valeria");
        System.out.println(map);

        Runnable runnable1 = () -> {
            Iterator< Integer> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer key = iterator.next();
                System.out.println(key + ":" + map.get(key));
            }
        };


    }

}
