package demo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dmitry on 16.12.15.
 */
public class MainClass {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("2", 3);
        map.put("2", 4);
        map.put("2", 1);
        map.put("2", 6);
        map.put("1", 3);
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
        System.out.println(map.get("2"));
        map.remove("2");
        for (Map.Entry<String, Integer> entry : map.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    }
}
